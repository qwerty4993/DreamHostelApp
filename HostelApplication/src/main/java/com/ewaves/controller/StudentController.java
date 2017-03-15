package com.ewaves.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ewaves.domain.ResponseVO;
import com.ewaves.entities.Student;
import com.ewaves.entities.StudentRequest;
import com.ewaves.service.StudentService;

@RestController

public class StudentController {
	@Autowired
	StudentService studentService;

	@RequestMapping(value = "/studentregistration/", method = RequestMethod.POST)
	public ResponseVO studentRegistration(@RequestBody Student employee) {
	
		
		ResponseVO responseVO = studentService.studentRegistration(employee);
		return responseVO;
	}
	
	@RequestMapping(value = "/user/userRequest", method = RequestMethod.POST)
	public @ResponseBody ResponseVO userRequest(@RequestBody StudentRequest userRequest) {
		System.out.println("In usercontroller : \n " + userRequest.toString());

		ResponseVO responseVO = studentService.addUserRequest(userRequest);

		return responseVO;

	}

}
