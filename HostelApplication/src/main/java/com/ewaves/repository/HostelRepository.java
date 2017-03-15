package com.ewaves.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ewaves.entities.HostelDetails;

@Repository
public interface HostelRepository
		extends CrudRepository<HostelDetails, Long>, JpaSpecificationExecutor<HostelDetails> {
	@Query("SELECT e FROM HostelDetails e where e.emailId=(:emailId)")
	HostelDetails findByEmail(@Param(value = "emailId") String emailId);

	@Query("SELECT e FROM HostelDetails e where e.phoneNumber=(:phoneNumber)")
	HostelDetails findByPhone(@Param(value = "phoneNumber") String phoneNumber);

	List<HostelDetails> findByCityAndState(String city, String state);

	List<HostelDetails> findByCity(String city);

	List<HostelDetails> findByState(String state);

	

	// @Value("${spring.queries.roles-query}")
	// private String rolesQuery;

}
