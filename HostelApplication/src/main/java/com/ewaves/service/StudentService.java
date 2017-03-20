package com.ewaves.service;

import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ewaves.domain.ResponseVO;
import com.ewaves.entities.HostelDetails;
import com.ewaves.entities.LoginDetails;
import com.ewaves.entities.Role;
import com.ewaves.entities.Student;
import com.ewaves.entities.StudentRequest;
import com.ewaves.repository.HostelRepository;
import com.ewaves.repository.LoginRepository;
import com.ewaves.repository.RoleRepository;
import com.ewaves.repository.StudentRepository;
import com.ewaves.repository.StudentRequestRepository;
import com.ewaves.util.HttpStatusCode;

@Service
public class StudentService {

	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private StudentRequestRepository studentRequestRepository;
	@Autowired
	private EmailService emailService;

	@Autowired
	private LoginRepository loginRepository;

	@Autowired
	private HostelRepository hostelRepository;

	public ResponseVO studentRegistration(Student studentVO) {

		Student dbPhoneNumber = studentRepository.findByphone(studentVO.getPhone());
		if (dbPhoneNumber != null) {
			return HttpStatusCode.ALREADY_PHONENUM_EXISTS.getResponseVO("FAILURE");
		}

		Student dbEmail = studentRepository.findByEmail(studentVO.getEmail());
		if (dbEmail != null) {
			return HttpStatusCode.ALREADY_EMAIL_EXISTS.getResponseVO("FAILURE");
		}
		LoginDetails userByName = loginRepository.findByUsername(studentVO.getUser().getUsername());

		if (userByName != null) {
			return HttpStatusCode.ALREADY_USERNAME_EXISTS.getResponseVO("FAILURE");
		}

		LoginDetails user = studentVO.getUser();

		user.setStudent(studentVO);

		if (user.getRole() != null) {
			Role dbRole = roleRepository.findOne(user.getRole().getId());
			if (dbRole == null) {
				return HttpStatusCode.UNAUTHORIZED.getResponseVO("NO Role Matched");
			}

			LoginDetails user1 = studentVO.getUser();
			System.out.println(dbRole.toString());
			user1.setRole(dbRole);
			studentVO.setUser(user1);
		}
		// user.setPassword(bCryptPasswordEncoder.encode(studentVO.getUser().getPassword()));
		user.setPassword(passwordEncoder.encode(studentVO.getUser().getPassword()));
		studentRepository.save(studentVO);

		return HttpStatusCode.CREATED.getResponseVO("SUCCESS");

	}

	public Student findStudentByEmail(String userEmail) {

		return studentRepository.findByEmail(userEmail);

	}

	public ResponseVO addUserRequest(StudentRequest userRequest) {

		Long hostelId = userRequest.getHostelDetails().getHostelId();
		System.out.println(hostelId);
		HostelDetails hostelDetails = hostelRepository.findOne(hostelId);
		userRequest.setStudent(userRequest.getStudent());
		userRequest.setInsertedOn(new Date());
		StudentRequest dbUserRequest = studentRequestRepository.save(userRequest);

		if (dbUserRequest == null) {
			return HttpStatusCode.NON_AUTHORITATIVE_INFORMATION.getResponseVO("FAILURE");

		}

		try {
			MimeMessage message = emailService.sendStudentRequestMail(hostelDetails, userRequest);

			Transport.send(message);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			return HttpStatusCode.NON_AUTHORITATIVE_INFORMATION.getResponseVO("Mail Not Sent");
		}
		return HttpStatusCode.CREATED.getResponseVO("SUCCESS");

	}

}