package org.wg.carbooking.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import sun.misc.BASE64Encoder;

public class MD5 {

	/**
	 * 用MD5对字符串进行编码
	 * 
	 * @author guoyidong
	 * @title: EncoderByMd5
	 * @param str 要加密的字符
	 * @return 加密后的md5字符
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 *             String
	 */
	public static String EncoderByMd5(String str)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {

		MessageDigest md5 = MessageDigest.getInstance("MD5");
		BASE64Encoder base64en = new BASE64Encoder();

		String newstr = base64en.encode(md5.digest(str.getBytes("utf-8")));
		return newstr;
	}
	
	/**
	 * 比对密码是否一致
	 * 
	 * @author guoyidong
	 * @title: checkpassword
	 * @param inputPasswd 用户输入的密码
	 * @param dataPasswd 数据库中用MD5加密过的密码
	 * @return true:两个密码是否一致?true:false
	 */
	public static boolean checkpassword(String inputPasswd, String dataPasswd) {
		try {
			if (EncoderByMd5(inputPasswd).equals(dataPasswd))
				return true;
			else
				return false;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return false;
	}
}
