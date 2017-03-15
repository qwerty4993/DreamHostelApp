package com.ewaves.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.ewaves.domain.FeatureLookup;

@Repository
public interface FeatureLookupRepository
		extends PagingAndSortingRepository<FeatureLookup, Long>, JpaSpecificationExecutor<FeatureLookup> {

	FeatureLookup findByName(String name);
}