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
package jpcsp.memory.mmio;

import jpcsp.Emulator;

public class MMIOHandlerDdr extends MMIOHandlerBase {
	public MMIOHandlerDdr(int baseAddress) {
		super(baseAddress);
	}

	private void doFlush(int value) {
		if (log.isDebugEnabled()) {
			log.debug(String.format("MMIOHandlerDdr.doFlush 0x%01X", value));
		}
	}

	@Override
	public int read32(int address) {
		int value;
		switch (address - baseAddress) {
			case 0x04: value = 0; break;
			default: value = super.read32(address); break;
		}

		if (log.isTraceEnabled()) {
			log.trace(String.format("0x%08X - read32(0x%08X) returning 0x%08X", Emulator.getProcessor().cpu.pc, address, value));
		}

		return value;
	}

	@Override
	public void write32(int address, int value) {
		switch (address - baseAddress) {
			case 0x04: doFlush(value); break;
			default: super.write32(address, value); break;
		}

		if (log.isTraceEnabled()) {
			log.trace(String.format("0x%08X - write32(0x%08X, 0x%08X) on %s", Emulator.getProcessor().cpu.pc, address, value, this));
		}
	}
}
