package com.ewaves.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ewaves.entities.VerificationToken;

public interface TokenRepository
		extends PagingAndSortingRepository<VerificationToken, Long>, JpaSpecificationExecutor<VerificationToken> {

	VerificationToken findByToken(String existingVerificationToken);

}
