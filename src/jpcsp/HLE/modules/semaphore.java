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
package jpcsp.HLE.modules;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import org.apache.log4j.Logger;

import jpcsp.HLE.BufferInfo;
import jpcsp.HLE.BufferInfo.LengthInfo;
import jpcsp.HLE.BufferInfo.Usage;
import jpcsp.HLE.CanBeNull;
import jpcsp.HLE.HLEFunction;
import jpcsp.HLE.HLELogging;
import jpcsp.HLE.HLEModule;
import jpcsp.HLE.HLEUnimplemented;
import jpcsp.HLE.Modules;
import jpcsp.HLE.TPointer;
import jpcsp.crypto.CryptoEngine;
import jpcsp.crypto.KIRK;
import jpcsp.memory.IMemoryReader;
import jpcsp.memory.IMemoryWriter;
import jpcsp.memory.MemoryReader;
import jpcsp.memory.MemoryWriter;
import jpcsp.util.Utilities;

public class semaphore extends HLEModule {
	public static Logger log = Modules.getLogger("semaphore");
	private static PreDecrypt preDecrypts[] = new PreDecrypt[] {
		new PreDecrypt(new int[] {
				0x05, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x5C, 0x00, 0x00, 0x00,
				0x90, 0x00, 0x00, 0x00, 0x00, 0xF7, 0xDF, 0x19, 0xD7, 0x10, 0xEA, 0x9F, 0x02, 0xDB, 0x3F, 0xB1,
				0x10, 0x9F, 0x26, 0x6B, 0x01, 0xF7, 0xDF, 0x19, 0xD7, 0x10, 0xEA, 0x9F, 0x02, 0xDB, 0x3F, 0xB1,
				0x10, 0x9F, 0x26, 0x6B, 0x02, 0xF7, 0xDF, 0x19, 0xD7, 0x10, 0xEA, 0x9F, 0x02, 0xDB, 0x3F, 0xB1,
				0x10, 0x9F, 0x26, 0x6B, 0x03, 0xF7, 0xDF, 0x19, 0xD7, 0x10, 0xEA, 0x9F, 0x02, 0xDB, 0x3F, 0xB1,
				0x10, 0x9F, 0x26, 0x6B, 0x04, 0xF7, 0xDF, 0x19, 0xD7, 0x10, 0xEA, 0x9F, 0x02, 0xDB, 0x3F, 0xB1,
				0x10, 0x9F, 0x26, 0x6B, 0x05, 0xF7, 0xDF, 0x19, 0xD7, 0x10, 0xEA, 0x9F, 0x02, 0xDB, 0x3F, 0xB1,
				0x10, 0x9F, 0x26, 0x6B, 0x06, 0xF7, 0xDF, 0x19, 0xD7, 0x10, 0xEA, 0x9F, 0x02, 0xDB, 0x3F, 0xB1,
				0x10, 0x9F, 0x26, 0x6B, 0x07, 0xF7, 0xDF, 0x19, 0xD7, 0x10, 0xEA, 0x9F, 0x02, 0xDB, 0x3F, 0xB1,
				0x10, 0x9F, 0x26, 0x6B, 0x08, 0xF7, 0xDF, 0x19, 0xD7, 0x10, 0xEA, 0x9F, 0x02, 0xDB, 0x3F, 0xB1,
				0x10, 0x9F, 0x26, 0x6B
			}, new int[] {
				0xAD, 0x50, 0x06, 0xA6, 0x87, 0x10, 0x37, 0x6E, 0x0E, 0x09, 0xBD, 0x63, 0xEE, 0xE0, 0x5A, 0x48,
				0x3C, 0x31, 0x07, 0xC2, 0x2F, 0x37, 0xA9, 0x71, 0x2E, 0x35, 0x06, 0x06, 0xBD, 0x05, 0x0C, 0x57,
				0xBE, 0x00, 0x1C, 0x7C, 0xD1, 0x5A, 0xC5, 0xB3, 0xA0, 0x52, 0x96, 0xE4, 0x64, 0xD4, 0x3F, 0x1B,
				0x62, 0x7F, 0x57, 0xF7, 0xC7, 0x92, 0x4D, 0xA3, 0xA3, 0x42, 0xE3, 0xA4, 0xBE, 0x2C, 0xC6, 0xB4,
				0xC0, 0xB9, 0x71, 0x76, 0x29, 0x06, 0xAF, 0xFE, 0xB6, 0x1E, 0x2E, 0x55, 0x0B, 0x97, 0xCE, 0x21,
				0xBF, 0xB9, 0x76, 0x31, 0x4A, 0x0A, 0xB6, 0x3D, 0x2B, 0x39, 0xD6, 0x3A, 0x9D, 0x87, 0x65, 0x10,
				0xF0, 0xF7, 0xA0, 0xA1, 0xEA, 0xB3, 0x29, 0x54, 0x51, 0x0A, 0x2E, 0x3C, 0xD7, 0x90, 0x7A, 0x4A,
				0x3C, 0xD8, 0x56, 0x76, 0x3A, 0x73, 0xA3, 0x53, 0xCB, 0x80, 0x3D, 0xDE, 0xC6, 0x85, 0x85, 0xEE,
				0x95, 0x49, 0xC5, 0x53, 0x48, 0xB1, 0x47, 0x44, 0x8C, 0xCF, 0x64, 0x62, 0xDA, 0x50, 0xE7, 0xF9,
				0x10, 0x9F, 0x26, 0x6B, 0x08, 0xF7, 0xDF, 0x19, 0xD7, 0x10, 0xEA, 0x9F, 0x02, 0xDB, 0x3F, 0xB1,
				0x10, 0x9F, 0x26, 0x6B
			}, KIRK.PSP_KIRK_CMD_DECRYPT),
		new PreDecrypt(new int[] {
				0x05, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x5C, 0x00, 0x00, 0x00,
				0x40, 0x00, 0x00, 0x00, 0xD7, 0x14, 0x08, 0x9C, 0xA1, 0x39, 0x63, 0x10, 0x5F, 0xB7, 0x2D, 0x1F,
				0x96, 0x7A, 0x0E, 0xCA, 0x25, 0x9C, 0xF6, 0x30, 0xA5, 0xF4, 0x3E, 0x82, 0x84, 0xE8, 0x00, 0x66,
				0x27, 0xCF, 0x14, 0x76, 0xA0, 0x95, 0xA6, 0x59, 0xCE, 0x02, 0x8F, 0xD2, 0x2A, 0x07, 0xC1, 0xA1,
				0x7D, 0x58, 0x5A, 0xCF, 0xB5, 0x0F, 0x3B, 0x4E, 0x29, 0x1D, 0xC0, 0x0B, 0x8F, 0x3F, 0x9B, 0xEC,
				0x36, 0x27, 0xF7, 0xC0
			}, new int[] {
				0xF3, 0xED, 0x4E, 0x39, 0xC5, 0x4F, 0x48, 0x2C, 0x40, 0x4F, 0x15, 0xA9, 0x54, 0x5F, 0xD4, 0x47,
				0xF1, 0xC8, 0xEE, 0xBF, 0x98, 0x5A, 0x05, 0xF3, 0xD7, 0xBA, 0xB9, 0x7F, 0xC4, 0x56, 0x9C, 0xDC,
				0xBA, 0xE4, 0x67, 0x20, 0x8B, 0xA9, 0x67, 0xBB, 0x13, 0xDC, 0xFD, 0xC4, 0x14, 0x1C, 0xDE, 0x2B,
				0xBB, 0x89, 0x11, 0xC7, 0xD0, 0xD9, 0x67, 0x59, 0xFD, 0x80, 0xCD, 0x37, 0x94, 0xA6, 0x84, 0x70,
				0x7D, 0x58, 0x5A, 0xCF, 0xB5, 0x0F, 0x3B, 0x4E, 0x29, 0x1D, 0xC0, 0x0B, 0x8F, 0x3F, 0x9B, 0xEC,
				0x36, 0x27, 0xF7, 0xC0
			}, KIRK.PSP_KIRK_CMD_DECRYPT),
		new PreDecrypt(new int[] {
				0x05, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x5C, 0x00, 0x00, 0x00,
				0x60, 0x00, 0x00, 0x00, 0xA3, 0x9C, 0x56, 0xD7, 0x15, 0x63, 0xCE, 0xC0, 0x98, 0x7E, 0xE4, 0x5E,
				0xA6, 0x35, 0xF5, 0xAE, 0x19, 0x64, 0x92, 0x82, 0x66, 0x81, 0x44, 0x6E, 0x86, 0xAB, 0xEB, 0xC4,
				0x34, 0xEE, 0x63, 0x57, 0x85, 0xEE, 0xEB, 0xB3, 0x9A, 0xF9, 0x7B, 0x5F, 0x60, 0xBA, 0xB1, 0x40,
				0xE8, 0x0A, 0xFC, 0x7C, 0x72, 0xA8, 0xB5, 0x11, 0xC2, 0xC4, 0x43, 0x5F, 0xE2, 0x9E, 0x77, 0xE1,
				0xB1, 0xCB, 0xCF, 0x16, 0x86, 0x4B, 0x51, 0x73, 0xE1, 0x2F, 0x5B, 0x34, 0x8F, 0x61, 0xC7, 0xEE,
				0x80, 0x64, 0xE5, 0xD7, 0x7E, 0x95, 0x20, 0x72, 0x78, 0xE8, 0xE6, 0x8E, 0xD5, 0xEE, 0xBC, 0x75,
				0xCC, 0xA6, 0x50, 0xE1
			}, new int[] {
				0xA4, 0xD2, 0x08, 0xDB, 0x83, 0xB0, 0xD9, 0x3C, 0xDF, 0xDD, 0x15, 0x4E, 0x19, 0xE7, 0x92, 0xEC,
				0xD6, 0x2A, 0x1D, 0x0C, 0x90, 0x11, 0xAD, 0xAF, 0xFB, 0xB4, 0x4C, 0xD2, 0x90, 0x48, 0x1C, 0x89,
				0x18, 0x7F, 0x2F, 0x5D, 0xEB, 0x25, 0x0F, 0x5E, 0x8E, 0x0E, 0xCA, 0x61, 0x71, 0x82, 0x2B, 0x19,
				0x2B, 0x7F, 0x02, 0x9D, 0x9B, 0x9C, 0xEA, 0x4C, 0x74, 0xAE, 0xFB, 0x31, 0x24, 0xBA, 0x96, 0x82,
				0x43, 0x1B, 0x2B, 0x6D, 0xC2, 0xEA, 0xF1, 0xAE, 0x09, 0x90, 0xC2, 0x71, 0x89, 0x45, 0x22, 0x05,
				0xC3, 0x74, 0x9C, 0x7B, 0x75, 0xB6, 0x4A, 0x38, 0x00, 0x1B, 0x6F, 0xF5, 0x39, 0x21, 0xB5, 0xB9,
				0x80, 0x64, 0xE5, 0xD7, 0x7E, 0x95, 0x20, 0x72, 0x78, 0xE8, 0xE6, 0x8E, 0xD5, 0xEE, 0xBC, 0x75,
				0xCC, 0xA6, 0x50, 0xE1
			}, KIRK.PSP_KIRK_CMD_DECRYPT)
	};

	private static class PreDecrypt {
		private byte[] preIn;
		private byte[] preOut;
		private int preCmd;

		public PreDecrypt(int[] preIn, int[] preOut, int preCmd) {
			this.preIn = new byte[preIn.length];
			for (int i = 0; i < preIn.length; i++) {
				this.preIn[i] = (byte) preIn[i];
			}

			this.preOut = new byte[preOut.length];
			for (int i = 0; i < preOut.length; i++) {
				this.preOut[i] = (byte) preOut[i];
			}

			this.preCmd = preCmd;
		}

		public boolean decrypt(byte[] out, int outSize, byte[] in, int inSize, int cmd) {
			if (preCmd != cmd) {
				return false;
			}
			if (preIn.length != inSize || preOut.length != outSize) {
				return false;
			}

			for (int i = 0; i < inSize; i++) {
				if (preIn[i] != in[i]) {
					return false;
				}
			}

			System.arraycopy(preOut, 0, out, 0, outSize);

			return true;
		}
	}

	private boolean preDecrypt(byte[] out, int outSize, byte[] in, int inSize, int cmd) {
		for (PreDecrypt preDecrypt : preDecrypts) {
			if (preDecrypt.decrypt(out, outSize, in, inSize, cmd)) {
				return true;
			}
		}

		return false;
	}

    public int hleUtilsBufferCopyWithRange(TPointer outAddr, int outSize, TPointer inAddr, int inSize, int cmd) {
		int originalInSize = inSize;

		// The input size needs for some KIRK commands to be 16-bytes aligned
    	inSize = Utilities.alignUp(inSize, 15);

    	// Read the whole input buffer, including a possible header
    	// (up to 144 bytes, depending on the KIRK command)
    	byte[] inBytes = new byte[inSize + 144]; // Up to 144 bytes header
    	ByteBuffer inBuffer = ByteBuffer.wrap(inBytes).order(ByteOrder.LITTLE_ENDIAN);
    	IMemoryReader memoryReaderIn = MemoryReader.getMemoryReader(inAddr, inSize, 1);
    	for (int i = 0; i < inSize; i++) {
    		inBytes[i] = (byte) memoryReaderIn.readNext();
    	}

    	// Some KIRK commands (e.g. PSP_KIRK_CMD_SHA1_HASH) only update a part of the output buffer.
    	// Read the whole output buffer so that it can be updated completely after the KIRK call.
    	byte[] outBytes = new byte[Utilities.alignUp(outSize, 15)];
    	ByteBuffer outBuffer = ByteBuffer.wrap(outBytes).order(ByteOrder.LITTLE_ENDIAN);
    	IMemoryReader memoryReaderOut = MemoryReader.getMemoryReader(outAddr, outBytes.length, 1);
    	for (int i = 0; i < outBytes.length; i++) {
    		outBytes[i] = (byte) memoryReaderOut.readNext();
    	}

    	int result = 0;
    	if (preDecrypt(outBytes, outSize, inBytes, originalInSize, cmd)) {
    		if (log.isDebugEnabled()) {
    			log.debug(String.format("sceUtilsBufferCopyWithRange using pre-decrypted data"));
    		}
    	} else {
	    	// Call the KIRK engine to perform the given command
	    	CryptoEngine crypto = new CryptoEngine();
	    	result = crypto.getKIRKEngine().hleUtilsBufferCopyWithRange(outBuffer, outSize, inBuffer, inSize, originalInSize, cmd);
	    	if (result != 0) {
	    		log.warn(String.format("hleUtilsBufferCopyWithRange cmd=0x%X returned 0x%X", cmd, result));
	    	}
    	}

    	// Write back the whole output buffer to the memory.
    	IMemoryWriter memoryWriter = MemoryWriter.getMemoryWriter(outAddr, outSize, 1);
    	for (int i = 0; i < outSize; i++) {
    		memoryWriter.writeNext(outBytes[i] & 0xFF);
    	}
    	memoryWriter.flush();

    	return result;
    }

    @HLELogging(level = "info")
    @HLEFunction(nid = 0x4C537C72, version = 150)
    public int sceUtilsBufferCopyWithRange(@CanBeNull @BufferInfo(lengthInfo=LengthInfo.nextParameter, usage=Usage.out) TPointer outAddr, int outSize, @CanBeNull @BufferInfo(lengthInfo=LengthInfo.nextParameter, usage=Usage.in) TPointer inAddr, int inSize, int cmd) {
    	hleUtilsBufferCopyWithRange(outAddr, outSize, inAddr, inSize, cmd);
    	// Fake a successful operation
    	return 0;
    }

	@HLELogging(level = "info")
    @HLEFunction(nid = 0x77E97079, version = 150)
    public int sceUtilsBufferCopyByPollingWithRange(TPointer outAddr, int outSize, TPointer inAddr, int inSize, int cmd) {
		return sceUtilsBufferCopyWithRange(outAddr, outSize, inAddr, inSize, cmd);
	}

	@HLEUnimplemented
	@HLEFunction(nid = 0x00EEC06A, version = 150)
	public int sceUtilsBufferCopy(TPointer outAddr, TPointer inAddr, int cmd) {
		return 0;
	}

	@HLEUnimplemented
	@HLEFunction(nid = 0x8EEB7BF2, version = 150)
	public int 	sceUtilsBufferCopyByPolling(TPointer outAddr, TPointer inAddr, int cmd) {
		return 0;
	}
}
