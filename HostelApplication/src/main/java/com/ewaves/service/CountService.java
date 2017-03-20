package com.ewaves.service;

import java.util.ArrayList;
import java.util.List;

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

	public List<CounttVO> getAllCount() {
		List<CounttVO> dbCountList = new ArrayList<CounttVO>();
		String dbHostelRequestCount = hostelRepository.findCoun();
		String dbStudentCount = studentRepository.findCoun();
		String dbStudentRequesCount=studentRequestRepository.finCount();
		
		
		CounttVO count = new CounttVO();
		count.setStudentRequestCount(dbStudentRequesCount);
		count.setHostelCount(dbHostelRequestCount);
		count.setStudentCount(dbStudentCount);
		
		dbCountList.add(count);
		return dbCountList;
	}

}
