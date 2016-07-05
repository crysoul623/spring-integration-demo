/**
 * 
 */
package com.spring.integration.demo.core.virtualchannel.transformer;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.integration.transformer.AbstractPayloadTransformer;

import com.spring.integration.demo.common.ThreeDESUtil;


/**
 * @author zoro02.lin
 * 解密Transformer
 */
public class VirtualEncryptTransformer extends AbstractPayloadTransformer<InputStream, byte[]> {

	private final static Logger logger = LoggerFactory.getLogger(VirtualEncryptTransformer.class);
	
	private static final int BUFFER_SIZE = 2048;
	
	@Value("#{reconcileSettings['virtual.channel.3des.key']}")
	private String key;
	
	@Override
	protected byte[] transformPayload(InputStream is) throws Exception {
		try (ByteArrayOutputStream bos = new ByteArrayOutputStream();) {
			byte[] buffer = new byte[BUFFER_SIZE];
			int read = 0;
			while ((read = is.read(buffer)) != -1) {
				bos.write(buffer, 0, read);
			}
			//3DES解密
			return ThreeDESUtil.decrypt(key, bos.toByteArray());
		} finally {
			if(is != null) {
				try {
					is.close();
				} catch (Exception ignore) {
					logger.warn("[VirtualEncryptTransformer] close inputstream failed, exception is : ", ignore);
				}
			}
		}
	}
	
}
