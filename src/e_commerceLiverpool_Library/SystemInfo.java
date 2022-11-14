package e_commerceLiverpool_Library;

import java.lang.management.ManagementFactory;

import com.sun.management.OperatingSystemMXBean;

public class SystemInfo {
	
	private static SystemInfo instance = new SystemInfo();
	private OperatingSystemMXBean operatingSystem;
	
	private Runtime runtime;
	
	private SystemInfo() {
		operatingSystem = (OperatingSystemMXBean)ManagementFactory.getOperatingSystemMXBean();
		runtime = Runtime.getRuntime();
	}
	
	static SystemInfo getInstance() {
		return instance;
	}
	
	long getFreePhysicalMemorySize() {
		return operatingSystem.getFreePhysicalMemorySize();
	}
	
	long getTotalPhysicalMemorySize() {
		return operatingSystem.getTotalPhysicalMemorySize();
	}
	// here
	double getSystemCpuLoad() {
		//int process = runtime.availableProcessors();
		return operatingSystem.getSystemCpuLoad();
	}
	
	// here JVM
	double getProcessCpuLoad() {
		return operatingSystem.getProcessCpuLoad();
	}
	
	// here Sys OP
	long getSystemAllocatedMemory() {
		return getTotalPhysicalMemorySize() - getFreePhysicalMemorySize();
	}
	// JVM
	long getTotaPhysicalMemory() {
		return runtime.maxMemory();
	}
	
	
	/*float getProcessMemoryLoad() {
		return getProcessAllocatedMemory() / (float) runtime.maxMemory(); /// here *******
	}*/
	
	double getRemainigMemorySize() {
		return getTotalPhysicalMemorySize() - getFreePhysicalMemorySize();
	}
	
	long getProcessPresumableFreeMemory() {
        return runtime.maxMemory() - getSystemAllocatedMemory();
    }
}
