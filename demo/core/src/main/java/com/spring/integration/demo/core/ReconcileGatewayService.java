package com.spring.integration.demo.core;

import org.springframework.integration.annotation.Gateway;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;

/**
 * @author zoro02.lin
 * 对帐网关
 */
public interface ReconcileGatewayService {

	/**
	 * 对帐网关
	 * @param channelCode		渠道号
	 * @param reconcileDate		对帐日期
	 * @return
	 */
	@Gateway(requestChannel="reconcileGatewayChannel")
	public String check(@Header("channelCode") String channelCode, @Payload String reconcileDate);
}
