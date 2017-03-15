package com.ewaves.service;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.ewaves.entities.SharingDetails;

@Repository
@Transactional
public interface SharingDetailsRepository
		extends PagingAndSortingRepository<SharingDetails, Long>, JpaSpecificationExecutor<SharingDetails> {

}
