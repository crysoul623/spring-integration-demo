/**
 * 
 */
package com.spring.integration.demo.common;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zoro02.lin
 * 3DES加密服务类
 */
public class ThreeDESUtil {

	private final static Logger logger = LoggerFactory.getLogger(ThreeDESUtil.class);
	
	private static final String ALGORITHM = "DESede";
	
	public static byte[] encrypt(String key, byte[] src) {
		try {
			//生成密钥
			SecretKey deskey = new SecretKeySpec(key.getBytes(), ALGORITHM);
			//加密
			Cipher c1 = Cipher.getInstance("DESede/ECB/PKCS5Padding");
			c1.init(Cipher.ENCRYPT_MODE, deskey);
			return c1.doFinal(src);
		} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
			logger.error("DESede encrypt error, the error is : ", e);
		}
		return null;
	}

	public static byte[] decrypt(String key, byte[] src) {
		try {
			//生成密钥
			SecretKey deskey = new SecretKeySpec(key.getBytes(), ALGORITHM);
			//解密
			Cipher c1 = Cipher.getInstance("DESede/ECB/PKCS5Padding");
			c1.init(Cipher.DECRYPT_MODE, deskey);
			return c1.doFinal(src);
		} catch (NoSuchAlgorithmException | InvalidKeyException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException e) {
			logger.error("DESede decrypt error, the error is : ", e);
		} 
		return null;
	}
}
