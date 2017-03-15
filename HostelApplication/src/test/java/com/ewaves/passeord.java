package com.ewaves;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class passeord {
	public static void main(String[] args) {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		String p = bCryptPasswordEncoder.encode("SomeCoolPassword");
		System.out.println(p);
		System.out.println(bCryptPasswordEncoder.matches("SomeCoolPassword", p));
	}
	
}
