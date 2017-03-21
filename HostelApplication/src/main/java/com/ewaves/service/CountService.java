package com.ewaves.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ewaves.domain.CounttVO;
import com.ewaves.repository.HostelRepository;
import com.ewaves.repository.StudentRepository;
import com.ewaves.repository.StudentRequestRepository;

@Service
public class CountService {

	@Autowired
	private HostelRepository hostelRepository;
	@Autowired
	private StudentRepository studentRepository;
	
	
	@Autowired
	private StudentRequestRepository studentRequestRepository;

	public CounttVO getAllCount() {
		

		String dbHostelNewRequestCount = hostelRepository.findCount();
		String dbHostelActiveCount = hostelRepository.findHostelActiveCount();
		String dbStudentCount = studentRepository.findCoun();
		String dbStudentNewRequesCount=studentRequestRepository.finCount();
		
		
		CounttVO count = new CounttVO();
		count.setStudentNewRequestCount(dbStudentNewRequesCount);
		count.setHostelNewRequestCount(dbHostelNewRequestCount);
		count.setStudentCount(dbStudentCount);
		count.setHostelActiveCount(dbHostelActiveCount);
		
		
		
		return count;
	}

}
