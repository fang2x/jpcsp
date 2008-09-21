/* This autogenerated file is part of jpcsp. */
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

package jpcsp.HLE.modules150;

import jpcsp.HLE.modules.HLEModule;
import jpcsp.HLE.modules.HLEModuleFunction;
import jpcsp.HLE.modules.HLEModuleManager;

import jpcsp.Memory;
import jpcsp.Processor;

import jpcsp.Allegrex.CpuState; // New-Style Processor

public class ModuleMgrForKernel implements HLEModule {
	@Override
	public String getName() { return "ModuleMgrForKernel"; }
	
	@Override
	public void installModule(HLEModuleManager mm, int version) {
		if (version >= 150) {
			
			mm.addFunction(sceKernelLoadModuleBufferWithApitypeFunction, 0xABE84F8A);
			
			mm.addFunction(sceKernelLoadModuleBufferFunction, 0xBA889C07);
			
			mm.addFunction(sceKernelLoadModuleByIDFunction, 0xB7F46618);
			
			mm.addFunction(sceKernelLoadModuleWithApitypeFunction, 0x437214AE);
			
			mm.addFunction(sceKernelLoadModuleFunction, 0x977DE386);
			
			mm.addFunction(sceKernelLoadModuleMsFunction, 0x710F61B5);
			
			mm.addFunction(sceKernelLoadModuleVSHByIDFunction, 0x91B87FAE);
			
			mm.addFunction(sceKernelLoadModuleVSHFunction, 0xA4370E7C);
			
			mm.addFunction(sceKernelLoadModuleVSHPlainFunction, 0x23425E93);
			
			mm.addFunction(sceKernelLoadModuleBufferUsbWlanFunction, 0xF9275D98);
			
			mm.addFunction(sceKernelLoadModuleBufferVSHFunction, 0xF0CAC59E);
			
			mm.addFunction(sceKernelStartModuleFunction, 0x50F0C1EC);
			
			mm.addFunction(sceKernelStopModuleFunction, 0xD1FF982A);
			
			mm.addFunction(sceKernelUnloadModuleFunction, 0x2E0911AA);
			
			mm.addFunction(sceKernelSelfStopUnloadModuleFunction, 0xD675EBB8);
			
			mm.addFunction(sceKernelStopUnloadSelfModuleFunction, 0xCC1D3699);
			
			mm.addFunction(sceKernelSearchModuleByNameFunction, 0x04B7BD22);
			
			mm.addFunction(sceKernelGetModuleIdListFunction, 0x644395E2);
			
			mm.addFunction(sceKernelSearchModuleByAddressFunction, 0x54D9E02E);
			
			mm.addFunction(sceKernelQueryModuleInfoFunction, 0x748CBED9);
			
			mm.addFunction(sceKernelGetModuleIdFunction, 0xF0A26395);
			
			mm.addFunction(sceKernelGetModuleIdByAddressFunction, 0xD8B73127);
			
			mm.addFunction(sceKernelRebootBeforeForUserFunction, 0x5F0CC575);
			
			mm.addFunction(sceKernelRebootPhaseForKernelFunction, 0xA6E8C1F5);
			
			mm.addFunction(sceKernelRebootBeforeForKernelFunction, 0xB49FFB9E);
			
		}
	}
	
	@Override
	public void uninstallModule(HLEModuleManager mm, int version) {
		if (version >= 150) {
			
			mm.removeFunction(sceKernelLoadModuleBufferWithApitypeFunction);
			
			mm.removeFunction(sceKernelLoadModuleBufferFunction);
			
			mm.removeFunction(sceKernelLoadModuleByIDFunction);
			
			mm.removeFunction(sceKernelLoadModuleWithApitypeFunction);
			
			mm.removeFunction(sceKernelLoadModuleFunction);
			
			mm.removeFunction(sceKernelLoadModuleMsFunction);
			
			mm.removeFunction(sceKernelLoadModuleVSHByIDFunction);
			
			mm.removeFunction(sceKernelLoadModuleVSHFunction);
			
			mm.removeFunction(sceKernelLoadModuleVSHPlainFunction);
			
			mm.removeFunction(sceKernelLoadModuleBufferUsbWlanFunction);
			
			mm.removeFunction(sceKernelLoadModuleBufferVSHFunction);
			
			mm.removeFunction(sceKernelStartModuleFunction);
			
			mm.removeFunction(sceKernelStopModuleFunction);
			
			mm.removeFunction(sceKernelUnloadModuleFunction);
			
			mm.removeFunction(sceKernelSelfStopUnloadModuleFunction);
			
			mm.removeFunction(sceKernelStopUnloadSelfModuleFunction);
			
			mm.removeFunction(sceKernelSearchModuleByNameFunction);
			
			mm.removeFunction(sceKernelGetModuleIdListFunction);
			
			mm.removeFunction(sceKernelSearchModuleByAddressFunction);
			
			mm.removeFunction(sceKernelQueryModuleInfoFunction);
			
			mm.removeFunction(sceKernelGetModuleIdFunction);
			
			mm.removeFunction(sceKernelGetModuleIdByAddressFunction);
			
			mm.removeFunction(sceKernelRebootBeforeForUserFunction);
			
			mm.removeFunction(sceKernelRebootPhaseForKernelFunction);
			
			mm.removeFunction(sceKernelRebootBeforeForKernelFunction);
			
		}
	}
	
	
	public void sceKernelLoadModuleBufferWithApitype(Processor processor) {
		// CpuState cpu = processor.cpu; // New-Style Processor
		Processor cpu = processor; // Old-Style Processor
		Memory mem = Processor.memory;		
		/* put your own code here instead */
		// int a0 = cpu.gpr[4];  int a1 = cpu.gpr[5];  int a2 = cpu.gpr[6];  int a3 = cpu.gpr[7];  int t0 = cpu.gpr[8];  int t1 = cpu.gpr[9];  int t2 = cpu.gpr[10];  int t3 = cpu.gpr[11];
		// float f12 = cpu.fpr[12];  float f13 = cpu.fpr[13];  float f14 = cpu.fpr[14];  float f15 = cpu.fpr[15];  float f16 = cpu.fpr[16];  float f17 = cpu.fpr[17];  float f18 = cpu.fpr[18]; float f19 = cpu.fpr[19];
		System.out.println("Unimplemented NID function sceKernelLoadModuleBufferWithApitype [0xABE84F8A]");
		// cpu.gpr[2] = (int)(result & 0xffffffff);  cpu.gpr[3] = (int)(result  32);
		// cpu.fpr[0] = result;
	}
    
	public void sceKernelLoadModuleBuffer(Processor processor) {
		// CpuState cpu = processor.cpu; // New-Style Processor
		Processor cpu = processor; // Old-Style Processor
		Memory mem = Processor.memory;		
		/* put your own code here instead */
		// int a0 = cpu.gpr[4];  int a1 = cpu.gpr[5];  int a2 = cpu.gpr[6];  int a3 = cpu.gpr[7];  int t0 = cpu.gpr[8];  int t1 = cpu.gpr[9];  int t2 = cpu.gpr[10];  int t3 = cpu.gpr[11];
		// float f12 = cpu.fpr[12];  float f13 = cpu.fpr[13];  float f14 = cpu.fpr[14];  float f15 = cpu.fpr[15];  float f16 = cpu.fpr[16];  float f17 = cpu.fpr[17];  float f18 = cpu.fpr[18]; float f19 = cpu.fpr[19];
		System.out.println("Unimplemented NID function sceKernelLoadModuleBuffer [0xBA889C07]");
		// cpu.gpr[2] = (int)(result & 0xffffffff);  cpu.gpr[3] = (int)(result  32);
		// cpu.fpr[0] = result;
	}
    
	public void sceKernelLoadModuleByID(Processor processor) {
		// CpuState cpu = processor.cpu; // New-Style Processor
		Processor cpu = processor; // Old-Style Processor
		Memory mem = Processor.memory;		
		/* put your own code here instead */
		// int a0 = cpu.gpr[4];  int a1 = cpu.gpr[5];  int a2 = cpu.gpr[6];  int a3 = cpu.gpr[7];  int t0 = cpu.gpr[8];  int t1 = cpu.gpr[9];  int t2 = cpu.gpr[10];  int t3 = cpu.gpr[11];
		// float f12 = cpu.fpr[12];  float f13 = cpu.fpr[13];  float f14 = cpu.fpr[14];  float f15 = cpu.fpr[15];  float f16 = cpu.fpr[16];  float f17 = cpu.fpr[17];  float f18 = cpu.fpr[18]; float f19 = cpu.fpr[19];
		System.out.println("Unimplemented NID function sceKernelLoadModuleByID [0xB7F46618]");
		// cpu.gpr[2] = (int)(result & 0xffffffff);  cpu.gpr[3] = (int)(result  32);
		// cpu.fpr[0] = result;
	}
    
	public void sceKernelLoadModuleWithApitype(Processor processor) {
		// CpuState cpu = processor.cpu; // New-Style Processor
		Processor cpu = processor; // Old-Style Processor
		Memory mem = Processor.memory;		
		/* put your own code here instead */
		// int a0 = cpu.gpr[4];  int a1 = cpu.gpr[5];  int a2 = cpu.gpr[6];  int a3 = cpu.gpr[7];  int t0 = cpu.gpr[8];  int t1 = cpu.gpr[9];  int t2 = cpu.gpr[10];  int t3 = cpu.gpr[11];
		// float f12 = cpu.fpr[12];  float f13 = cpu.fpr[13];  float f14 = cpu.fpr[14];  float f15 = cpu.fpr[15];  float f16 = cpu.fpr[16];  float f17 = cpu.fpr[17];  float f18 = cpu.fpr[18]; float f19 = cpu.fpr[19];
		System.out.println("Unimplemented NID function sceKernelLoadModuleWithApitype [0x437214AE]");
		// cpu.gpr[2] = (int)(result & 0xffffffff);  cpu.gpr[3] = (int)(result  32);
		// cpu.fpr[0] = result;
	}
    
	public void sceKernelLoadModule(Processor processor) {
		// CpuState cpu = processor.cpu; // New-Style Processor
		Processor cpu = processor; // Old-Style Processor
		Memory mem = Processor.memory;		
		/* put your own code here instead */
		// int a0 = cpu.gpr[4];  int a1 = cpu.gpr[5];  int a2 = cpu.gpr[6];  int a3 = cpu.gpr[7];  int t0 = cpu.gpr[8];  int t1 = cpu.gpr[9];  int t2 = cpu.gpr[10];  int t3 = cpu.gpr[11];
		// float f12 = cpu.fpr[12];  float f13 = cpu.fpr[13];  float f14 = cpu.fpr[14];  float f15 = cpu.fpr[15];  float f16 = cpu.fpr[16];  float f17 = cpu.fpr[17];  float f18 = cpu.fpr[18]; float f19 = cpu.fpr[19];
		System.out.println("Unimplemented NID function sceKernelLoadModule [0x977DE386]");
		// cpu.gpr[2] = (int)(result & 0xffffffff);  cpu.gpr[3] = (int)(result  32);
		// cpu.fpr[0] = result;
	}
    
	public void sceKernelLoadModuleMs(Processor processor) {
		// CpuState cpu = processor.cpu; // New-Style Processor
		Processor cpu = processor; // Old-Style Processor
		Memory mem = Processor.memory;		
		/* put your own code here instead */
		// int a0 = cpu.gpr[4];  int a1 = cpu.gpr[5];  int a2 = cpu.gpr[6];  int a3 = cpu.gpr[7];  int t0 = cpu.gpr[8];  int t1 = cpu.gpr[9];  int t2 = cpu.gpr[10];  int t3 = cpu.gpr[11];
		// float f12 = cpu.fpr[12];  float f13 = cpu.fpr[13];  float f14 = cpu.fpr[14];  float f15 = cpu.fpr[15];  float f16 = cpu.fpr[16];  float f17 = cpu.fpr[17];  float f18 = cpu.fpr[18]; float f19 = cpu.fpr[19];
		System.out.println("Unimplemented NID function sceKernelLoadModuleMs [0x710F61B5]");
		// cpu.gpr[2] = (int)(result & 0xffffffff);  cpu.gpr[3] = (int)(result  32);
		// cpu.fpr[0] = result;
	}
    
	public void sceKernelLoadModuleVSHByID(Processor processor) {
		// CpuState cpu = processor.cpu; // New-Style Processor
		Processor cpu = processor; // Old-Style Processor
		Memory mem = Processor.memory;		
		/* put your own code here instead */
		// int a0 = cpu.gpr[4];  int a1 = cpu.gpr[5];  int a2 = cpu.gpr[6];  int a3 = cpu.gpr[7];  int t0 = cpu.gpr[8];  int t1 = cpu.gpr[9];  int t2 = cpu.gpr[10];  int t3 = cpu.gpr[11];
		// float f12 = cpu.fpr[12];  float f13 = cpu.fpr[13];  float f14 = cpu.fpr[14];  float f15 = cpu.fpr[15];  float f16 = cpu.fpr[16];  float f17 = cpu.fpr[17];  float f18 = cpu.fpr[18]; float f19 = cpu.fpr[19];
		System.out.println("Unimplemented NID function sceKernelLoadModuleVSHByID [0x91B87FAE]");
		// cpu.gpr[2] = (int)(result & 0xffffffff);  cpu.gpr[3] = (int)(result  32);
		// cpu.fpr[0] = result;
	}
    
	public void sceKernelLoadModuleVSH(Processor processor) {
		// CpuState cpu = processor.cpu; // New-Style Processor
		Processor cpu = processor; // Old-Style Processor
		Memory mem = Processor.memory;		
		/* put your own code here instead */
		// int a0 = cpu.gpr[4];  int a1 = cpu.gpr[5];  int a2 = cpu.gpr[6];  int a3 = cpu.gpr[7];  int t0 = cpu.gpr[8];  int t1 = cpu.gpr[9];  int t2 = cpu.gpr[10];  int t3 = cpu.gpr[11];
		// float f12 = cpu.fpr[12];  float f13 = cpu.fpr[13];  float f14 = cpu.fpr[14];  float f15 = cpu.fpr[15];  float f16 = cpu.fpr[16];  float f17 = cpu.fpr[17];  float f18 = cpu.fpr[18]; float f19 = cpu.fpr[19];
		System.out.println("Unimplemented NID function sceKernelLoadModuleVSH [0xA4370E7C]");
		// cpu.gpr[2] = (int)(result & 0xffffffff);  cpu.gpr[3] = (int)(result  32);
		// cpu.fpr[0] = result;
	}
    
	public void sceKernelLoadModuleVSHPlain(Processor processor) {
		// CpuState cpu = processor.cpu; // New-Style Processor
		Processor cpu = processor; // Old-Style Processor
		Memory mem = Processor.memory;		
		/* put your own code here instead */
		// int a0 = cpu.gpr[4];  int a1 = cpu.gpr[5];  int a2 = cpu.gpr[6];  int a3 = cpu.gpr[7];  int t0 = cpu.gpr[8];  int t1 = cpu.gpr[9];  int t2 = cpu.gpr[10];  int t3 = cpu.gpr[11];
		// float f12 = cpu.fpr[12];  float f13 = cpu.fpr[13];  float f14 = cpu.fpr[14];  float f15 = cpu.fpr[15];  float f16 = cpu.fpr[16];  float f17 = cpu.fpr[17];  float f18 = cpu.fpr[18]; float f19 = cpu.fpr[19];
		System.out.println("Unimplemented NID function sceKernelLoadModuleVSHPlain [0x23425E93]");
		// cpu.gpr[2] = (int)(result & 0xffffffff);  cpu.gpr[3] = (int)(result  32);
		// cpu.fpr[0] = result;
	}
    
	public void sceKernelLoadModuleBufferUsbWlan(Processor processor) {
		// CpuState cpu = processor.cpu; // New-Style Processor
		Processor cpu = processor; // Old-Style Processor
		Memory mem = Processor.memory;		
		/* put your own code here instead */
		// int a0 = cpu.gpr[4];  int a1 = cpu.gpr[5];  int a2 = cpu.gpr[6];  int a3 = cpu.gpr[7];  int t0 = cpu.gpr[8];  int t1 = cpu.gpr[9];  int t2 = cpu.gpr[10];  int t3 = cpu.gpr[11];
		// float f12 = cpu.fpr[12];  float f13 = cpu.fpr[13];  float f14 = cpu.fpr[14];  float f15 = cpu.fpr[15];  float f16 = cpu.fpr[16];  float f17 = cpu.fpr[17];  float f18 = cpu.fpr[18]; float f19 = cpu.fpr[19];
		System.out.println("Unimplemented NID function sceKernelLoadModuleBufferUsbWlan [0xF9275D98]");
		// cpu.gpr[2] = (int)(result & 0xffffffff);  cpu.gpr[3] = (int)(result  32);
		// cpu.fpr[0] = result;
	}
    
	public void sceKernelLoadModuleBufferVSH(Processor processor) {
		// CpuState cpu = processor.cpu; // New-Style Processor
		Processor cpu = processor; // Old-Style Processor
		Memory mem = Processor.memory;		
		/* put your own code here instead */
		// int a0 = cpu.gpr[4];  int a1 = cpu.gpr[5];  int a2 = cpu.gpr[6];  int a3 = cpu.gpr[7];  int t0 = cpu.gpr[8];  int t1 = cpu.gpr[9];  int t2 = cpu.gpr[10];  int t3 = cpu.gpr[11];
		// float f12 = cpu.fpr[12];  float f13 = cpu.fpr[13];  float f14 = cpu.fpr[14];  float f15 = cpu.fpr[15];  float f16 = cpu.fpr[16];  float f17 = cpu.fpr[17];  float f18 = cpu.fpr[18]; float f19 = cpu.fpr[19];
		System.out.println("Unimplemented NID function sceKernelLoadModuleBufferVSH [0xF0CAC59E]");
		// cpu.gpr[2] = (int)(result & 0xffffffff);  cpu.gpr[3] = (int)(result  32);
		// cpu.fpr[0] = result;
	}
    
	public void sceKernelStartModule(Processor processor) {
		// CpuState cpu = processor.cpu; // New-Style Processor
		Processor cpu = processor; // Old-Style Processor
		Memory mem = Processor.memory;		
		/* put your own code here instead */
		// int a0 = cpu.gpr[4];  int a1 = cpu.gpr[5];  int a2 = cpu.gpr[6];  int a3 = cpu.gpr[7];  int t0 = cpu.gpr[8];  int t1 = cpu.gpr[9];  int t2 = cpu.gpr[10];  int t3 = cpu.gpr[11];
		// float f12 = cpu.fpr[12];  float f13 = cpu.fpr[13];  float f14 = cpu.fpr[14];  float f15 = cpu.fpr[15];  float f16 = cpu.fpr[16];  float f17 = cpu.fpr[17];  float f18 = cpu.fpr[18]; float f19 = cpu.fpr[19];
		System.out.println("Unimplemented NID function sceKernelStartModule [0x50F0C1EC]");
		// cpu.gpr[2] = (int)(result & 0xffffffff);  cpu.gpr[3] = (int)(result  32);
		// cpu.fpr[0] = result;
	}
    
	public void sceKernelStopModule(Processor processor) {
		// CpuState cpu = processor.cpu; // New-Style Processor
		Processor cpu = processor; // Old-Style Processor
		Memory mem = Processor.memory;		
		/* put your own code here instead */
		// int a0 = cpu.gpr[4];  int a1 = cpu.gpr[5];  int a2 = cpu.gpr[6];  int a3 = cpu.gpr[7];  int t0 = cpu.gpr[8];  int t1 = cpu.gpr[9];  int t2 = cpu.gpr[10];  int t3 = cpu.gpr[11];
		// float f12 = cpu.fpr[12];  float f13 = cpu.fpr[13];  float f14 = cpu.fpr[14];  float f15 = cpu.fpr[15];  float f16 = cpu.fpr[16];  float f17 = cpu.fpr[17];  float f18 = cpu.fpr[18]; float f19 = cpu.fpr[19];
		System.out.println("Unimplemented NID function sceKernelStopModule [0xD1FF982A]");
		// cpu.gpr[2] = (int)(result & 0xffffffff);  cpu.gpr[3] = (int)(result  32);
		// cpu.fpr[0] = result;
	}
    
	public void sceKernelUnloadModule(Processor processor) {
		// CpuState cpu = processor.cpu; // New-Style Processor
		Processor cpu = processor; // Old-Style Processor
		Memory mem = Processor.memory;		
		/* put your own code here instead */
		// int a0 = cpu.gpr[4];  int a1 = cpu.gpr[5];  int a2 = cpu.gpr[6];  int a3 = cpu.gpr[7];  int t0 = cpu.gpr[8];  int t1 = cpu.gpr[9];  int t2 = cpu.gpr[10];  int t3 = cpu.gpr[11];
		// float f12 = cpu.fpr[12];  float f13 = cpu.fpr[13];  float f14 = cpu.fpr[14];  float f15 = cpu.fpr[15];  float f16 = cpu.fpr[16];  float f17 = cpu.fpr[17];  float f18 = cpu.fpr[18]; float f19 = cpu.fpr[19];
		System.out.println("Unimplemented NID function sceKernelUnloadModule [0x2E0911AA]");
		// cpu.gpr[2] = (int)(result & 0xffffffff);  cpu.gpr[3] = (int)(result  32);
		// cpu.fpr[0] = result;
	}
    
	public void sceKernelSelfStopUnloadModule(Processor processor) {
		// CpuState cpu = processor.cpu; // New-Style Processor
		Processor cpu = processor; // Old-Style Processor
		Memory mem = Processor.memory;		
		/* put your own code here instead */
		// int a0 = cpu.gpr[4];  int a1 = cpu.gpr[5];  int a2 = cpu.gpr[6];  int a3 = cpu.gpr[7];  int t0 = cpu.gpr[8];  int t1 = cpu.gpr[9];  int t2 = cpu.gpr[10];  int t3 = cpu.gpr[11];
		// float f12 = cpu.fpr[12];  float f13 = cpu.fpr[13];  float f14 = cpu.fpr[14];  float f15 = cpu.fpr[15];  float f16 = cpu.fpr[16];  float f17 = cpu.fpr[17];  float f18 = cpu.fpr[18]; float f19 = cpu.fpr[19];
		System.out.println("Unimplemented NID function sceKernelSelfStopUnloadModule [0xD675EBB8]");
		// cpu.gpr[2] = (int)(result & 0xffffffff);  cpu.gpr[3] = (int)(result  32);
		// cpu.fpr[0] = result;
	}
    
	public void sceKernelStopUnloadSelfModule(Processor processor) {
		// CpuState cpu = processor.cpu; // New-Style Processor
		Processor cpu = processor; // Old-Style Processor
		Memory mem = Processor.memory;		
		/* put your own code here instead */
		// int a0 = cpu.gpr[4];  int a1 = cpu.gpr[5];  int a2 = cpu.gpr[6];  int a3 = cpu.gpr[7];  int t0 = cpu.gpr[8];  int t1 = cpu.gpr[9];  int t2 = cpu.gpr[10];  int t3 = cpu.gpr[11];
		// float f12 = cpu.fpr[12];  float f13 = cpu.fpr[13];  float f14 = cpu.fpr[14];  float f15 = cpu.fpr[15];  float f16 = cpu.fpr[16];  float f17 = cpu.fpr[17];  float f18 = cpu.fpr[18]; float f19 = cpu.fpr[19];
		System.out.println("Unimplemented NID function sceKernelStopUnloadSelfModule [0xCC1D3699]");
		// cpu.gpr[2] = (int)(result & 0xffffffff);  cpu.gpr[3] = (int)(result  32);
		// cpu.fpr[0] = result;
	}
    
	public void sceKernelSearchModuleByName(Processor processor) {
		// CpuState cpu = processor.cpu; // New-Style Processor
		Processor cpu = processor; // Old-Style Processor
		Memory mem = Processor.memory;		
		/* put your own code here instead */
		// int a0 = cpu.gpr[4];  int a1 = cpu.gpr[5];  int a2 = cpu.gpr[6];  int a3 = cpu.gpr[7];  int t0 = cpu.gpr[8];  int t1 = cpu.gpr[9];  int t2 = cpu.gpr[10];  int t3 = cpu.gpr[11];
		// float f12 = cpu.fpr[12];  float f13 = cpu.fpr[13];  float f14 = cpu.fpr[14];  float f15 = cpu.fpr[15];  float f16 = cpu.fpr[16];  float f17 = cpu.fpr[17];  float f18 = cpu.fpr[18]; float f19 = cpu.fpr[19];
		System.out.println("Unimplemented NID function sceKernelSearchModuleByName [0x04B7BD22]");
		// cpu.gpr[2] = (int)(result & 0xffffffff);  cpu.gpr[3] = (int)(result  32);
		// cpu.fpr[0] = result;
	}
    
	public void sceKernelGetModuleIdList(Processor processor) {
		// CpuState cpu = processor.cpu; // New-Style Processor
		Processor cpu = processor; // Old-Style Processor
		Memory mem = Processor.memory;		
		/* put your own code here instead */
		// int a0 = cpu.gpr[4];  int a1 = cpu.gpr[5];  int a2 = cpu.gpr[6];  int a3 = cpu.gpr[7];  int t0 = cpu.gpr[8];  int t1 = cpu.gpr[9];  int t2 = cpu.gpr[10];  int t3 = cpu.gpr[11];
		// float f12 = cpu.fpr[12];  float f13 = cpu.fpr[13];  float f14 = cpu.fpr[14];  float f15 = cpu.fpr[15];  float f16 = cpu.fpr[16];  float f17 = cpu.fpr[17];  float f18 = cpu.fpr[18]; float f19 = cpu.fpr[19];
		System.out.println("Unimplemented NID function sceKernelGetModuleIdList [0x644395E2]");
		// cpu.gpr[2] = (int)(result & 0xffffffff);  cpu.gpr[3] = (int)(result  32);
		// cpu.fpr[0] = result;
	}
    
	public void sceKernelSearchModuleByAddress(Processor processor) {
		// CpuState cpu = processor.cpu; // New-Style Processor
		Processor cpu = processor; // Old-Style Processor
		Memory mem = Processor.memory;		
		/* put your own code here instead */
		// int a0 = cpu.gpr[4];  int a1 = cpu.gpr[5];  int a2 = cpu.gpr[6];  int a3 = cpu.gpr[7];  int t0 = cpu.gpr[8];  int t1 = cpu.gpr[9];  int t2 = cpu.gpr[10];  int t3 = cpu.gpr[11];
		// float f12 = cpu.fpr[12];  float f13 = cpu.fpr[13];  float f14 = cpu.fpr[14];  float f15 = cpu.fpr[15];  float f16 = cpu.fpr[16];  float f17 = cpu.fpr[17];  float f18 = cpu.fpr[18]; float f19 = cpu.fpr[19];
		System.out.println("Unimplemented NID function sceKernelSearchModuleByAddress [0x54D9E02E]");
		// cpu.gpr[2] = (int)(result & 0xffffffff);  cpu.gpr[3] = (int)(result  32);
		// cpu.fpr[0] = result;
	}
    
	public void sceKernelQueryModuleInfo(Processor processor) {
		// CpuState cpu = processor.cpu; // New-Style Processor
		Processor cpu = processor; // Old-Style Processor
		Memory mem = Processor.memory;		
		/* put your own code here instead */
		// int a0 = cpu.gpr[4];  int a1 = cpu.gpr[5];  int a2 = cpu.gpr[6];  int a3 = cpu.gpr[7];  int t0 = cpu.gpr[8];  int t1 = cpu.gpr[9];  int t2 = cpu.gpr[10];  int t3 = cpu.gpr[11];
		// float f12 = cpu.fpr[12];  float f13 = cpu.fpr[13];  float f14 = cpu.fpr[14];  float f15 = cpu.fpr[15];  float f16 = cpu.fpr[16];  float f17 = cpu.fpr[17];  float f18 = cpu.fpr[18]; float f19 = cpu.fpr[19];
		System.out.println("Unimplemented NID function sceKernelQueryModuleInfo [0x748CBED9]");
		// cpu.gpr[2] = (int)(result & 0xffffffff);  cpu.gpr[3] = (int)(result  32);
		// cpu.fpr[0] = result;
	}
    
	public void sceKernelGetModuleId(Processor processor) {
		// CpuState cpu = processor.cpu; // New-Style Processor
		Processor cpu = processor; // Old-Style Processor
		Memory mem = Processor.memory;		
		/* put your own code here instead */
		// int a0 = cpu.gpr[4];  int a1 = cpu.gpr[5];  int a2 = cpu.gpr[6];  int a3 = cpu.gpr[7];  int t0 = cpu.gpr[8];  int t1 = cpu.gpr[9];  int t2 = cpu.gpr[10];  int t3 = cpu.gpr[11];
		// float f12 = cpu.fpr[12];  float f13 = cpu.fpr[13];  float f14 = cpu.fpr[14];  float f15 = cpu.fpr[15];  float f16 = cpu.fpr[16];  float f17 = cpu.fpr[17];  float f18 = cpu.fpr[18]; float f19 = cpu.fpr[19];
		System.out.println("Unimplemented NID function sceKernelGetModuleId [0xF0A26395]");
		// cpu.gpr[2] = (int)(result & 0xffffffff);  cpu.gpr[3] = (int)(result  32);
		// cpu.fpr[0] = result;
	}
    
	public void sceKernelGetModuleIdByAddress(Processor processor) {
		// CpuState cpu = processor.cpu; // New-Style Processor
		Processor cpu = processor; // Old-Style Processor
		Memory mem = Processor.memory;		
		/* put your own code here instead */
		// int a0 = cpu.gpr[4];  int a1 = cpu.gpr[5];  int a2 = cpu.gpr[6];  int a3 = cpu.gpr[7];  int t0 = cpu.gpr[8];  int t1 = cpu.gpr[9];  int t2 = cpu.gpr[10];  int t3 = cpu.gpr[11];
		// float f12 = cpu.fpr[12];  float f13 = cpu.fpr[13];  float f14 = cpu.fpr[14];  float f15 = cpu.fpr[15];  float f16 = cpu.fpr[16];  float f17 = cpu.fpr[17];  float f18 = cpu.fpr[18]; float f19 = cpu.fpr[19];
		System.out.println("Unimplemented NID function sceKernelGetModuleIdByAddress [0xD8B73127]");
		// cpu.gpr[2] = (int)(result & 0xffffffff);  cpu.gpr[3] = (int)(result  32);
		// cpu.fpr[0] = result;
	}
    
	public void sceKernelRebootBeforeForUser(Processor processor) {
		// CpuState cpu = processor.cpu; // New-Style Processor
		Processor cpu = processor; // Old-Style Processor
		Memory mem = Processor.memory;		
		/* put your own code here instead */
		// int a0 = cpu.gpr[4];  int a1 = cpu.gpr[5];  int a2 = cpu.gpr[6];  int a3 = cpu.gpr[7];  int t0 = cpu.gpr[8];  int t1 = cpu.gpr[9];  int t2 = cpu.gpr[10];  int t3 = cpu.gpr[11];
		// float f12 = cpu.fpr[12];  float f13 = cpu.fpr[13];  float f14 = cpu.fpr[14];  float f15 = cpu.fpr[15];  float f16 = cpu.fpr[16];  float f17 = cpu.fpr[17];  float f18 = cpu.fpr[18]; float f19 = cpu.fpr[19];
		System.out.println("Unimplemented NID function sceKernelRebootBeforeForUser [0x5F0CC575]");
		// cpu.gpr[2] = (int)(result & 0xffffffff);  cpu.gpr[3] = (int)(result  32);
		// cpu.fpr[0] = result;
	}
    
	public void sceKernelRebootPhaseForKernel(Processor processor) {
		// CpuState cpu = processor.cpu; // New-Style Processor
		Processor cpu = processor; // Old-Style Processor
		Memory mem = Processor.memory;		
		/* put your own code here instead */
		// int a0 = cpu.gpr[4];  int a1 = cpu.gpr[5];  int a2 = cpu.gpr[6];  int a3 = cpu.gpr[7];  int t0 = cpu.gpr[8];  int t1 = cpu.gpr[9];  int t2 = cpu.gpr[10];  int t3 = cpu.gpr[11];
		// float f12 = cpu.fpr[12];  float f13 = cpu.fpr[13];  float f14 = cpu.fpr[14];  float f15 = cpu.fpr[15];  float f16 = cpu.fpr[16];  float f17 = cpu.fpr[17];  float f18 = cpu.fpr[18]; float f19 = cpu.fpr[19];
		System.out.println("Unimplemented NID function sceKernelRebootPhaseForKernel [0xA6E8C1F5]");
		// cpu.gpr[2] = (int)(result & 0xffffffff);  cpu.gpr[3] = (int)(result  32);
		// cpu.fpr[0] = result;
	}
    
	public void sceKernelRebootBeforeForKernel(Processor processor) {
		// CpuState cpu = processor.cpu; // New-Style Processor
		Processor cpu = processor; // Old-Style Processor
		Memory mem = Processor.memory;		
		/* put your own code here instead */
		// int a0 = cpu.gpr[4];  int a1 = cpu.gpr[5];  int a2 = cpu.gpr[6];  int a3 = cpu.gpr[7];  int t0 = cpu.gpr[8];  int t1 = cpu.gpr[9];  int t2 = cpu.gpr[10];  int t3 = cpu.gpr[11];
		// float f12 = cpu.fpr[12];  float f13 = cpu.fpr[13];  float f14 = cpu.fpr[14];  float f15 = cpu.fpr[15];  float f16 = cpu.fpr[16];  float f17 = cpu.fpr[17];  float f18 = cpu.fpr[18]; float f19 = cpu.fpr[19];
		System.out.println("Unimplemented NID function sceKernelRebootBeforeForKernel [0xB49FFB9E]");
		// cpu.gpr[2] = (int)(result & 0xffffffff);  cpu.gpr[3] = (int)(result  32);
		// cpu.fpr[0] = result;
	}
    
	public final HLEModuleFunction sceKernelLoadModuleBufferWithApitypeFunction = new HLEModuleFunction("ModuleMgrForKernel", "sceKernelLoadModuleBufferWithApitype") {
		@Override
		public final void execute(Processor processor) {
			sceKernelLoadModuleBufferWithApitype(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.modules150.ModuleMgrForKernel.sceKernelLoadModuleBufferWithApitypeFunction.execute(processor);";
		}
	};
    
	public final HLEModuleFunction sceKernelLoadModuleBufferFunction = new HLEModuleFunction("ModuleMgrForKernel", "sceKernelLoadModuleBuffer") {
		@Override
		public final void execute(Processor processor) {
			sceKernelLoadModuleBuffer(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.modules150.ModuleMgrForKernel.sceKernelLoadModuleBufferFunction.execute(processor);";
		}
	};
    
	public final HLEModuleFunction sceKernelLoadModuleByIDFunction = new HLEModuleFunction("ModuleMgrForKernel", "sceKernelLoadModuleByID") {
		@Override
		public final void execute(Processor processor) {
			sceKernelLoadModuleByID(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.modules150.ModuleMgrForKernel.sceKernelLoadModuleByIDFunction.execute(processor);";
		}
	};
    
	public final HLEModuleFunction sceKernelLoadModuleWithApitypeFunction = new HLEModuleFunction("ModuleMgrForKernel", "sceKernelLoadModuleWithApitype") {
		@Override
		public final void execute(Processor processor) {
			sceKernelLoadModuleWithApitype(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.modules150.ModuleMgrForKernel.sceKernelLoadModuleWithApitypeFunction.execute(processor);";
		}
	};
    
	public final HLEModuleFunction sceKernelLoadModuleFunction = new HLEModuleFunction("ModuleMgrForKernel", "sceKernelLoadModule") {
		@Override
		public final void execute(Processor processor) {
			sceKernelLoadModule(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.modules150.ModuleMgrForKernel.sceKernelLoadModuleFunction.execute(processor);";
		}
	};
    
	public final HLEModuleFunction sceKernelLoadModuleMsFunction = new HLEModuleFunction("ModuleMgrForKernel", "sceKernelLoadModuleMs") {
		@Override
		public final void execute(Processor processor) {
			sceKernelLoadModuleMs(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.modules150.ModuleMgrForKernel.sceKernelLoadModuleMsFunction.execute(processor);";
		}
	};
    
	public final HLEModuleFunction sceKernelLoadModuleVSHByIDFunction = new HLEModuleFunction("ModuleMgrForKernel", "sceKernelLoadModuleVSHByID") {
		@Override
		public final void execute(Processor processor) {
			sceKernelLoadModuleVSHByID(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.modules150.ModuleMgrForKernel.sceKernelLoadModuleVSHByIDFunction.execute(processor);";
		}
	};
    
	public final HLEModuleFunction sceKernelLoadModuleVSHFunction = new HLEModuleFunction("ModuleMgrForKernel", "sceKernelLoadModuleVSH") {
		@Override
		public final void execute(Processor processor) {
			sceKernelLoadModuleVSH(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.modules150.ModuleMgrForKernel.sceKernelLoadModuleVSHFunction.execute(processor);";
		}
	};
    
	public final HLEModuleFunction sceKernelLoadModuleVSHPlainFunction = new HLEModuleFunction("ModuleMgrForKernel", "sceKernelLoadModuleVSHPlain") {
		@Override
		public final void execute(Processor processor) {
			sceKernelLoadModuleVSHPlain(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.modules150.ModuleMgrForKernel.sceKernelLoadModuleVSHPlainFunction.execute(processor);";
		}
	};
    
	public final HLEModuleFunction sceKernelLoadModuleBufferUsbWlanFunction = new HLEModuleFunction("ModuleMgrForKernel", "sceKernelLoadModuleBufferUsbWlan") {
		@Override
		public final void execute(Processor processor) {
			sceKernelLoadModuleBufferUsbWlan(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.modules150.ModuleMgrForKernel.sceKernelLoadModuleBufferUsbWlanFunction.execute(processor);";
		}
	};
    
	public final HLEModuleFunction sceKernelLoadModuleBufferVSHFunction = new HLEModuleFunction("ModuleMgrForKernel", "sceKernelLoadModuleBufferVSH") {
		@Override
		public final void execute(Processor processor) {
			sceKernelLoadModuleBufferVSH(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.modules150.ModuleMgrForKernel.sceKernelLoadModuleBufferVSHFunction.execute(processor);";
		}
	};
    
	public final HLEModuleFunction sceKernelStartModuleFunction = new HLEModuleFunction("ModuleMgrForKernel", "sceKernelStartModule") {
		@Override
		public final void execute(Processor processor) {
			sceKernelStartModule(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.modules150.ModuleMgrForKernel.sceKernelStartModuleFunction.execute(processor);";
		}
	};
    
	public final HLEModuleFunction sceKernelStopModuleFunction = new HLEModuleFunction("ModuleMgrForKernel", "sceKernelStopModule") {
		@Override
		public final void execute(Processor processor) {
			sceKernelStopModule(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.modules150.ModuleMgrForKernel.sceKernelStopModuleFunction.execute(processor);";
		}
	};
    
	public final HLEModuleFunction sceKernelUnloadModuleFunction = new HLEModuleFunction("ModuleMgrForKernel", "sceKernelUnloadModule") {
		@Override
		public final void execute(Processor processor) {
			sceKernelUnloadModule(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.modules150.ModuleMgrForKernel.sceKernelUnloadModuleFunction.execute(processor);";
		}
	};
    
	public final HLEModuleFunction sceKernelSelfStopUnloadModuleFunction = new HLEModuleFunction("ModuleMgrForKernel", "sceKernelSelfStopUnloadModule") {
		@Override
		public final void execute(Processor processor) {
			sceKernelSelfStopUnloadModule(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.modules150.ModuleMgrForKernel.sceKernelSelfStopUnloadModuleFunction.execute(processor);";
		}
	};
    
	public final HLEModuleFunction sceKernelStopUnloadSelfModuleFunction = new HLEModuleFunction("ModuleMgrForKernel", "sceKernelStopUnloadSelfModule") {
		@Override
		public final void execute(Processor processor) {
			sceKernelStopUnloadSelfModule(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.modules150.ModuleMgrForKernel.sceKernelStopUnloadSelfModuleFunction.execute(processor);";
		}
	};
    
	public final HLEModuleFunction sceKernelSearchModuleByNameFunction = new HLEModuleFunction("ModuleMgrForKernel", "sceKernelSearchModuleByName") {
		@Override
		public final void execute(Processor processor) {
			sceKernelSearchModuleByName(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.modules150.ModuleMgrForKernel.sceKernelSearchModuleByNameFunction.execute(processor);";
		}
	};
    
	public final HLEModuleFunction sceKernelGetModuleIdListFunction = new HLEModuleFunction("ModuleMgrForKernel", "sceKernelGetModuleIdList") {
		@Override
		public final void execute(Processor processor) {
			sceKernelGetModuleIdList(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.modules150.ModuleMgrForKernel.sceKernelGetModuleIdListFunction.execute(processor);";
		}
	};
    
	public final HLEModuleFunction sceKernelSearchModuleByAddressFunction = new HLEModuleFunction("ModuleMgrForKernel", "sceKernelSearchModuleByAddress") {
		@Override
		public final void execute(Processor processor) {
			sceKernelSearchModuleByAddress(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.modules150.ModuleMgrForKernel.sceKernelSearchModuleByAddressFunction.execute(processor);";
		}
	};
    
	public final HLEModuleFunction sceKernelQueryModuleInfoFunction = new HLEModuleFunction("ModuleMgrForKernel", "sceKernelQueryModuleInfo") {
		@Override
		public final void execute(Processor processor) {
			sceKernelQueryModuleInfo(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.modules150.ModuleMgrForKernel.sceKernelQueryModuleInfoFunction.execute(processor);";
		}
	};
    
	public final HLEModuleFunction sceKernelGetModuleIdFunction = new HLEModuleFunction("ModuleMgrForKernel", "sceKernelGetModuleId") {
		@Override
		public final void execute(Processor processor) {
			sceKernelGetModuleId(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.modules150.ModuleMgrForKernel.sceKernelGetModuleIdFunction.execute(processor);";
		}
	};
    
	public final HLEModuleFunction sceKernelGetModuleIdByAddressFunction = new HLEModuleFunction("ModuleMgrForKernel", "sceKernelGetModuleIdByAddress") {
		@Override
		public final void execute(Processor processor) {
			sceKernelGetModuleIdByAddress(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.modules150.ModuleMgrForKernel.sceKernelGetModuleIdByAddressFunction.execute(processor);";
		}
	};
    
	public final HLEModuleFunction sceKernelRebootBeforeForUserFunction = new HLEModuleFunction("ModuleMgrForKernel", "sceKernelRebootBeforeForUser") {
		@Override
		public final void execute(Processor processor) {
			sceKernelRebootBeforeForUser(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.modules150.ModuleMgrForKernel.sceKernelRebootBeforeForUserFunction.execute(processor);";
		}
	};
    
	public final HLEModuleFunction sceKernelRebootPhaseForKernelFunction = new HLEModuleFunction("ModuleMgrForKernel", "sceKernelRebootPhaseForKernel") {
		@Override
		public final void execute(Processor processor) {
			sceKernelRebootPhaseForKernel(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.modules150.ModuleMgrForKernel.sceKernelRebootPhaseForKernelFunction.execute(processor);";
		}
	};
    
	public final HLEModuleFunction sceKernelRebootBeforeForKernelFunction = new HLEModuleFunction("ModuleMgrForKernel", "sceKernelRebootBeforeForKernel") {
		@Override
		public final void execute(Processor processor) {
			sceKernelRebootBeforeForKernel(processor);
		}
		@Override
		public final String compiledString() {
			return "jpcsp.HLE.modules150.ModuleMgrForKernel.sceKernelRebootBeforeForKernelFunction.execute(processor);";
		}
	};
    
};
