package com.pope.contract.util;

import java.util.Random;

/**
 * 随机生成字符服务类
 * 
 * @author 01113120
 * 
 */
public class StringRandom {

	/**
	 * 随机生成随机数字和字母
	 * 
	 * @param length
	 *            字符长度
	 * @return
	 */
	public static String getStringRandom(int length) {
		String val = "";
		Random random = new Random();

		for (int i = 0; i < length; i++) {
			String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
			// 输出字母还是数字
			if ("char".equalsIgnoreCase(charOrNum)) {
				// 输出是大写字母还是小写字母
				int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
				val += (char) (random.nextInt(26) + temp);
			} else if ("num".equalsIgnoreCase(charOrNum)) {
				val += String.valueOf(random.nextInt(10));
			}
		}
		return val;
	}

	/**
	 * 随机生成随机数字
	 * 
	 * @param length
	 *            字符长度
	 * @return
	 */
	public static String getNumberRandom(int length) {
		String val = "";
		Random random = new Random();

		for (int i = 0; i < length; i++) {
			val += String.valueOf(random.nextInt(10));
		}
		return val;
	}

	public static void main(String[] args) {
		System.out.println(getStringRandom(6));
		System.out.println(getNumberRandom(6));
	}
}
