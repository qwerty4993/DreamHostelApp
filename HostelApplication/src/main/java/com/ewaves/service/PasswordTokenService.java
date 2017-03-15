package com.ewaves.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ewaves.entities.PasswordResetToken;
import com.ewaves.entities.Student;
import com.ewaves.repository.PasswordTokenRepository;

@Service
public class PasswordTokenService {
	@Autowired
	private PasswordTokenRepository passwordTokenRepository;

	public void createPasswordResetTokenForUser(final Student user, final String token) {
		final PasswordResetToken myToken = new PasswordResetToken(token, user);
		passwordTokenRepository.save(myToken);
	}
}
