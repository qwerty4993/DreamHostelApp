package com.ewaves.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.ewaves.entities.FeatureLookup;

@Repository
public interface FeatureLookupRepository
		extends PagingAndSortingRepository<FeatureLookup, Long>, JpaSpecificationExecutor<FeatureLookup> {

	FeatureLookup findByName(String name);
}