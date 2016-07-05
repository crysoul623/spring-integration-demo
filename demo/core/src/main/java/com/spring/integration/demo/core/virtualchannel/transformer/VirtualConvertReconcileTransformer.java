/**
 * 
 */
package com.spring.integration.demo.core.virtualchannel.transformer;

import java.io.BufferedReader;
import java.io.StringReader;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.integration.transformer.AbstractPayloadTransformer;

import com.spring.integration.demo.core.AccountStatementBO;


/**
 * @author zoro02.lin
 * 对帐文件转换为对帐模型
 */
public class VirtualConvertReconcileTransformer extends AbstractPayloadTransformer<String, List<AccountStatementBO>>{

	@Override
	protected List<AccountStatementBO> transformPayload(String payload) throws Exception {
		try(BufferedReader br = new BufferedReader(new StringReader(payload));) {
			return br.lines().map(line -> {
				String[] params = line.split("\\|");
				AccountStatementBO accountStatementBO = new AccountStatementBO();
				accountStatementBO.setOrderNo(params[1]);
				accountStatementBO.setReplyNo(params[2]);
				accountStatementBO.setOrderType(params[3]);
				accountStatementBO.setAmount(new BigDecimal(params[4]));
				accountStatementBO.setStatus(params[6]);
				return accountStatementBO;
			}).collect(Collectors.toList());
		}
	}

}