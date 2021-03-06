/*
This file is part of jpcsp.

Jpcsp is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

Jpcsp is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with Jpcsp.  If not, see <http://www.gnu.org/licenses/>.
 */
package jpcsp.Allegrex.compiler;

import java.io.IOException;

import org.apache.log4j.Logger;

import jpcsp.Emulator;
import jpcsp.Memory;
import jpcsp.Processor;
import jpcsp.HLE.kernel.managers.ExceptionManager;
import jpcsp.HLE.kernel.managers.IntrManager;
import jpcsp.HLE.modules.reboot;
import jpcsp.mediaengine.MEProcessor;
import jpcsp.mediaengine.METhread;
import jpcsp.memory.mmio.MMIO;
import jpcsp.memory.mmio.MMIOHandlerInterruptMan;
import jpcsp.state.StateInputStream;
import jpcsp.state.StateOutputStream;

/**
 * @author gid15
 *
 */
public class RuntimeContextLLE {
	public static Logger log = RuntimeContext.log;
	private static final int STATE_VERSION = 0;
	private static final boolean isLLEActive = reboot.enableReboot;
	private static Memory mmio;
	public volatile static int pendingInterruptIPbits;

	public static boolean isLLEActive() {
		return isLLEActive;
	}

	public static void start() {
		if (!isLLEActive()) {
			return;
		}

		createMMIO();
	}

	public static void createMMIO() {
		if (!isLLEActive()) {
			return;
		}

		if (mmio == null) {
			mmio = new MMIO(Emulator.getMemory());
			if (mmio.allocate()) {
				mmio.Initialise();
			} else {
				mmio = null;
			}
		}
	}

	public static Memory getMMIO() {
		return mmio;
	}

	public static void triggerInterrupt(Processor processor, int interruptNumber) {
		if (!isLLEActive()) {
			return;
		}

		MMIOHandlerInterruptMan interruptMan = MMIOHandlerInterruptMan.getInstance(processor);
		if (!interruptMan.hasInterruptTriggered(interruptNumber)) {
			if (log.isDebugEnabled()) {
				log.debug(String.format("triggerInterrupt 0x%X(%s)", interruptNumber, IntrManager.getInterruptName(interruptNumber)));
			}

			interruptMan.triggerInterrupt(interruptNumber);
		}
	}

	public static void clearInterrupt(Processor processor, int interruptNumber) {
		if (!isLLEActive()) {
			return;
		}

		MMIOHandlerInterruptMan interruptMan = MMIOHandlerInterruptMan.getInstance(processor);
		if (interruptMan.hasInterruptTriggered(interruptNumber)) {
			if (log.isDebugEnabled()) {
				log.debug(String.format("clearInterrupt 0x%X(%s)", interruptNumber, IntrManager.getInterruptName(interruptNumber)));
			}

			interruptMan.clearInterrupt(interruptNumber);
		}
	}

	/*
	 * synchronized method as it can be called from different threads (e.g. CoreThreadMMIO)
	 */
	public static synchronized void triggerInterruptException(Processor processor, int IPbits) {
		if (!isLLEActive()) {
			return;
		}

		if (processor.cp0.isMainCpu()) {
			pendingInterruptIPbits |= IPbits;

			if (log.isDebugEnabled()) {
				log.debug(String.format("triggerInterruptException IPbits=0x%X, pendingInterruptIPbits=0x%X", IPbits, pendingInterruptIPbits));
			}
		}
	}

	public static int triggerSyscallException(Processor processor, int syscallCode, boolean inDelaySlot) {
		processor.cp0.setSyscallCode(syscallCode << 2);
		int ebase = triggerException(processor, ExceptionManager.EXCEP_SYS, inDelaySlot);

		if (log.isDebugEnabled()) {
			log.debug(String.format("Calling exception handler for Syscall at 0x%08X, epc=0x%08X", ebase, processor.cp0.getEpc()));
		}

		return ebase;
	}

	public static int triggerBreakException(Processor processor, boolean inDelaySlot) {
		int ebase = triggerException(processor, ExceptionManager.EXCEP_BP, inDelaySlot);

		if (log.isDebugEnabled()) {
			log.debug(String.format("Calling exception handler for Break at 0x%08X, epc=0x%08X", ebase, processor.cp0.getEpc()));
		}

		return ebase;
	}

	public static boolean isMediaEngineCpu() {
		if (!isLLEActive()) {
			return false;
		}
		return METhread.isMediaEngine(Thread.currentThread());
	}

	public static boolean isMainCpu() {
		if (!isLLEActive()) {
			return true;
		}
		return !isMediaEngineCpu();
	}

	public static Processor getMainProcessor() {
		return Emulator.getProcessor();
	}

	public static MEProcessor getMediaEngineProcessor() {
		return MEProcessor.getInstance();
	}

	public static Processor getProcessor() {
		if (isMediaEngineCpu()) {
			return getMediaEngineProcessor();
		}
		return getMainProcessor();
	}

	public static int triggerException(Processor processor, int exceptionNumber, boolean inDelaySlot) {
		return prepareExceptionHandlerCall(processor, exceptionNumber, inDelaySlot);
	}

	/*
	 * synchronized method as it can be called from different threads (e.g. CoreThreadMMIO)
	 */
	public static synchronized void clearInterruptException(Processor processor, int IPbits) {
		if (!isLLEActive()) {
			return;
		}

		pendingInterruptIPbits &= ~IPbits;
	}

	private static boolean isInterruptExceptionAllowed(Processor processor, int IPbits) {
		if (IPbits == 0) {
			log.debug("IPbits == 0");
			return false;
		}

		if (processor.isInterruptsDisabled()) {
			log.debug("Interrupts disabled");
			return false;
		}

		int status = processor.cp0.getStatus();
		if (log.isDebugEnabled()) {
			log.debug(String.format("cp0 Status=0x%X", status));
		}

		// Is the processor already in an exception state?
		if ((status & 0x2) != 0) {
			return false;
		}

		// Is the interrupt masked?
		if ((status & 0x1) == 0 || ((IPbits << 8) & status) == 0) {
			return false;
		}

		return true;
	}

	private static int prepareExceptionHandlerCall(Processor processor, int exceptionNumber, boolean inDelaySlot) {
		// Set the exception number and BD flag
		int cause = processor.cp0.getCause();
		cause = (cause & 0xFFFFFF00) | (exceptionNumber << 2);
		if (inDelaySlot) {
			cause |= 0x80000000; // Set BD flag (Branch Delay Slot)
		} else {
			cause &= ~0x80000000; // Clear BD flag (Branch Delay Slot)
		}
		processor.cp0.setCause(cause);

		int epc = processor.cpu.pc;

		if (inDelaySlot) {
			epc -= 4; // The EPC is set to the instruction having the delay slot
		}

		// Set the EPC
		processor.cp0.setEpc(epc);

		int ebase = processor.cp0.getEbase();

		// Set the EXL bit
		int status = processor.cp0.getStatus();
		status |= 0x2; // Set EXL bit
		processor.cp0.setStatus(status);

		return ebase;
	}

	/*
	 * synchronized method as it is modifying pendingInterruptIPbits which can be updated from different threads
	 */
	public static synchronized int checkPendingInterruptException(int returnAddress) {
		Processor processor = getProcessor();
		if (isInterruptExceptionAllowed(processor, pendingInterruptIPbits)) {
			int cause = processor.cp0.getCause();
			cause |= (pendingInterruptIPbits << 8);
			pendingInterruptIPbits = 0;
			processor.cp0.setCause(cause);

			// The compiler is only calling this function when
			// we are not in a delay slot
			int ebase = prepareExceptionHandlerCall(processor, ExceptionManager.EXCEP_INT, false);

			if (log.isDebugEnabled()) {
				log.debug(String.format("Calling exception handler for %s at 0x%08X, epc=0x%08X, cause=0x%X", MMIOHandlerInterruptMan.getInstance(processor).toStringInterruptTriggered(), ebase, processor.cp0.getEpc(), processor.cp0.getCause()));
			}

			return ebase;
		}

		return returnAddress;
	}

	/*
	 * synchronized method as it is modifying pendingInterruptIPbits which can be updated from different threads
	 */
	public static synchronized void read(StateInputStream stream) throws IOException {
		stream.readVersion(STATE_VERSION);
		pendingInterruptIPbits = stream.readInt();
	}

	/*
	 * synchronized method as it is reading pendingInterruptIPbits which can be updated from different threads
	 */
	public static synchronized void write(StateOutputStream stream) throws IOException {
		stream.writeVersion(STATE_VERSION);
		stream.writeInt(pendingInterruptIPbits);
	}
}
