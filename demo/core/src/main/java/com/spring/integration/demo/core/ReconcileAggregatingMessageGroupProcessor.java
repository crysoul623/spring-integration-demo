/**
 * 
 */
package com.spring.integration.demo.core;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.integration.aggregator.AbstractAggregatingMessageGroupProcessor;
import org.springframework.integration.store.MessageGroup;
import org.springframework.messaging.Message;
import org.springframework.util.Assert;

/**
 * @author zoro02.lin
 *
 */
public class ReconcileAggregatingMessageGroupProcessor extends AbstractAggregatingMessageGroupProcessor {

	/* (non-Javadoc)
	 * @see org.springframework.integration.aggregator.AbstractAggregatingMessageGroupProcessor#aggregatePayloads(org.springframework.integration.store.MessageGroup, java.util.Map)
	 */
	@Override
	@SuppressWarnings("unchecked")
	protected Object aggregatePayloads(MessageGroup group, Map<String, Object> defaultHeaders) {
		Collection<Message<?>> messages = group.getMessages();
		Assert.notEmpty(messages, this.getClass().getSimpleName() + " cannot process empty message groups");
		
		return messages.stream().map(m -> {
			return (List<AccountStatementBO>) m.getPayload();
		}).flatMap(List::stream).collect(Collectors.toList());
	}

}
