package com.ewaves.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.ewaves.entities.PasswordResetToken;

public interface PasswordTokenRepository
		extends CrudRepository<PasswordResetToken, Long>, JpaRepository<PasswordResetToken, Long> {

	PasswordResetToken findByToken(String token);

}
