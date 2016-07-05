/**
 * 
 */
package com.spring.integration.demo.core;

import java.math.BigDecimal;

/**
 * @author zoro02.lin
 * 对账模型
 */
public class AccountStatementBO {

	private String orderNo;
	
	private String orderType;
	
	private BigDecimal amount;
	
	private String status;
	
	private String replyNo;

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getReplyNo() {
		return replyNo;
	}

	public void setReplyNo(String replyNo) {
		this.replyNo = replyNo;
	}
	
}
