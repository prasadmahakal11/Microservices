//ProjectInfo.java
package com.nt.sbeans;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "info.app")
public class ProjectInfo {
	private  String name;
	private  String  vendor;
	private  int  size;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	@Override
	public String toString() {
		return "ProjectInfo [name=" + name + ", vendor=" + vendor + ", size=" + size + "]";
	}
	
	@Scheduled(initialDelay = 10 , fixedDelay = 1000)
	public    void   showDetails() {
		 System.out.println(" all about  project ");
	}
	

}
