/**
 * 
 */
package com.spring.integration.demo.core.virtualchannel.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.spring.integration.demo.core.AccountStatementBO;


/**
 * @author zoro02.lin
 * rw
 */
public class VirtualChannelRowMapper implements RowMapper<AccountStatementBO> {

	@Override
	public AccountStatementBO mapRow(ResultSet rs, int rowNum) throws SQLException {
		AccountStatementBO accountStatementBO = new AccountStatementBO();
		accountStatementBO.setOrderNo(rs.getString("REQUEST_NO"));
		accountStatementBO.setOrderType(rs.getString("TYPE"));
		accountStatementBO.setReplyNo(rs.getString("RECEIPT_NO"));
		accountStatementBO.setAmount(rs.getBigDecimal("AMOUNT"));
		accountStatementBO.setStatus(rs.getString("STATUS"));
		return accountStatementBO;
	}

}
