/**
 * 
 */
package com.spring.integration.demo.common;

/**
 * @author zoro02.lin
 * 平台类型
 */
public enum PlatformType {
	
	VIP_SHOP("VIP", "唯品会"),
	
	VIRTUAL_BANK("VB", "虚拟银行"),
	
	;

	private String platformCode;
	
	private String name;

	private PlatformType(String platformCode, String name) {
		this.platformCode = platformCode;
		this.name = name;
	}

	public String getPlatformCode() {
		return platformCode;
	}

	public String getName() {
		return name;
	}
	
}
