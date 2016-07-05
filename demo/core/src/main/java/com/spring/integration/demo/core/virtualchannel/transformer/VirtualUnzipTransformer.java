/**
 * 
 */
package com.spring.integration.demo.core.virtualchannel.transformer;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.springframework.integration.transformer.AbstractPayloadTransformer;

/**
 * @author zoro02.lin
 * 解压transformer
 */
public class VirtualUnzipTransformer extends AbstractPayloadTransformer<byte[], String> {

	private static final int BUFFER_SIZE = 2048;
	
	@Override
	protected String transformPayload(byte[] payload) throws Exception {
		try (InputStream is = new ByteArrayInputStream(payload); ZipInputStream zis = new ZipInputStream(is);) {
			StringBuilder sb = new StringBuilder();
			byte[] buffer = new byte[BUFFER_SIZE];
			int read = 0;
			ZipEntry zipEntry = zis.getNextEntry();
			if (zipEntry != null) {
				while ((read = zis.read(buffer)) != -1) {
					sb.append(new String(buffer, 0, read, Charset.forName("UTF-8")));
				}
			}
			return sb.toString();
		}
	}

}
