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
package jpcsp.hardware;

import jpcsp.Allegrex.compiler.RuntimeContextLLE;
import jpcsp.HLE.kernel.managers.IntrManager;

public class Interrupts {
	private static boolean interruptsEnabled = true;

    public static void initialize() {
    	interruptsEnabled = true;
    }

	public static boolean isInterruptsEnabled() {
		return interruptsEnabled;
	}

	public static boolean isInterruptsDisabled() {
		return !isInterruptsEnabled();
	}

	public static void setInterruptsEnabled(boolean interruptsEnabled) {
		if (Interrupts.interruptsEnabled != interruptsEnabled) {
			Interrupts.interruptsEnabled = interruptsEnabled;

			if (interruptsEnabled) {
				// Interrupts have been enabled
				IntrManager.getInstance().onInterruptsEnabled();
				RuntimeContextLLE.checkPendingInterruptException();
			}
		}
	}

	public static void enableInterrupts() {
		setInterruptsEnabled(true);
	}

	public static void disableInterrupts() {
		setInterruptsEnabled(false);
	}
}
