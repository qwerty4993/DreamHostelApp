package com.ewaves.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ewaves.entities.Student;

public interface StudentRepository extends PagingAndSortingRepository<Student, Long>, JpaSpecificationExecutor<Student> {

	Student findByphone(String phone);

	Student findByEmail(String email);

}
