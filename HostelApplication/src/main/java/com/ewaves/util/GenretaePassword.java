package com.ewaves.util;

import java.security.SecureRandom;

public class GenretaePassword {
	final String passwordGenerete = "@#$&0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	SecureRandom rnd = new SecureRandom();

	String randomString() {
		int len=7;
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append(passwordGenerete.charAt(rnd.nextInt(passwordGenerete.length())));
		return sb.toString();
	}

	/*public static void main(String[] args) {

		GenretaePassword c = new GenretaePassword();
		System.out.println(c.randomString(7));

	}*/
}