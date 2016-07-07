/**
 * 
 */
package com.spring.integration.demo.core;

import java.util.stream.Stream;

import org.springframework.messaging.Message;

/**
 * @author zoro02.lin
 *
 */
public class ReconcileServiceActivator {

	public void handle(Message<?> message) {
		Stream.of(message.getPayload());
	}
}
