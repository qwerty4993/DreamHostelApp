package com.ewaves.service;

import static org.mockito.Matchers.anyCollection;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ewaves.domain.HostelFilterVO;
import com.ewaves.domain.ResponseVO;
import com.ewaves.domain.RoomDetailsVO;
import com.ewaves.entities.HostelDetails;
import com.ewaves.entities.LoginDetails;
import com.ewaves.entities.Role;
import com.ewaves.entities.SharingDetails;
import com.ewaves.repository.HostelRepository;
import com.ewaves.repository.LoginRepository;
import com.ewaves.util.HttpStatusCode;

@Service
public class HostelService {

	@Autowired
	private HostelRepository hostelRepossitory;
	@Autowired
	private EmailService emailSerice;

	@Autowired
	private SharingDetailsRepository sharingDetailsRepository;
	@Autowired
	private HostelRepository hostelRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private LoginRepository loginRepository;

	public ResponseVO hostelRequest(HostelDetails hostelDeails) {

		HostelDetails dbEmail = hostelRepossitory.findByEmail(hostelDeails.getEmailId());

		if (dbEmail != null) {
			return HttpStatusCode.ALREADY_EMAIL_EXISTS.getResponseVO("FAILURE");
		}
		HostelDetails dbphoneNumber = hostelRepossitory.findByPhone(hostelDeails.getPhoneNumber());
		if (dbphoneNumber != null) {
			return HttpStatusCode.ALREADY_PHONENUM_EXISTS.getResponseVO("FAILURE");
		}
		HostelDetails details = hostelRepossitory.save(hostelDeails);
		try {
			MimeMessage message = emailSerice.sendNewHostelRequestMail(details);

			Transport.send(message);
		} catch (MessagingException e) {
			return HttpStatusCode.ALREADY_PHONENUM_EXISTS.getResponseVO("FAILURE");
		}
		return HttpStatusCode.CREATED.getResponseVO("SUCCESS");

	}

	public ResponseVO getAllHostels() {
		ResponseVO responseVO = new ResponseVO();
		List<HostelDetails> finalDataList = new ArrayList<>();
		List<HostelDetails> list = (List<HostelDetails>) hostelRepossitory.findAll();
		for (HostelDetails hostelDetails : list) {
			if (hostelDetails.getIsEnable() == true) {
				finalDataList.add(hostelDetails);

			}
		}
		responseVO = HttpStatusCode.FOUND.getResponseVO("SUCCESS");

		responseVO.setResponseObjects(finalDataList);

		return responseVO;
	}

	public ResponseVO getAllHostels1(String city, String state) {
		ResponseVO responseVO = new ResponseVO();
		if (state.isEmpty() && city.isEmpty()) {
			return HttpStatusCode.NON_AUTHORITATIVE_INFORMATION.getResponseVO("city or state should not be empty");
		}
		if (state.isEmpty()) {
			List<HostelDetails> hostelDetailsList = hostelRepossitory.findByCity(city);
			responseVO = HttpStatusCode.FOUND.getResponseVO("city details");
			responseVO.setResponseObjects(hostelDetailsList);
			return responseVO;
		} else if (city.isEmpty()) {
			List<HostelDetails> hostelDetailsList = hostelRepossitory.findByState(state);
			responseVO = HttpStatusCode.FOUND.getResponseVO("state details");
			responseVO.setResponseObjects(hostelDetailsList);
			return responseVO;
		}
		List<HostelDetails> hostelDetailsList = hostelRepossitory.findByCityAndState(city, state);

		// HostelDetails cityStateList = hostelDetailsList.get();
		if (hostelDetailsList != null) {
			return HttpStatusCode.NON_AUTHORITATIVE_INFORMATION.getResponseVO("city or state should not be empty");
		}

		responseVO = HttpStatusCode.FOUND.getResponseVO("SUCCESS");
		responseVO.setResponseObjects(hostelDetailsList);

		return responseVO;
	}

	public ResponseVO addRoom(RoomDetailsVO requestVO) {

		List<SharingDetails> sharingDetailList = requestVO.getSharingDetails();

		for (SharingDetails sharingDetails : sharingDetailList) {
			if (sharingDetails.getSharingType().toString().isEmpty()
					&& sharingDetails.getNoOfPersonAvailability().toString().isEmpty()) {
				return HttpStatusCode.FOUND.getResponseVO("avaliable");
			}
			sharingDetails.setInsertedOn(LocalDateTime.now());
			sharingDetailList.add(sharingDetails);
		}

		sharingDetailsRepository.save(sharingDetailList);

		return HttpStatusCode.FOUND.getResponseVO("SUCCESS");
	}

	public List<HostelDetails> getAllHostelsForApproval() {
		List<HostelDetails> finalDataList = new ArrayList<>();
		List<HostelDetails> list = (List<HostelDetails>) hostelRepossitory.findAll();
		for (HostelDetails hostelDetails : list) {
			if (hostelDetails.getIsEnable() == false) {

				finalDataList.add(hostelDetails);
			}

		}
		return finalDataList;

	}

	public HostelDetails findHostelById(Long id) {
		HostelDetails dbHostelDetails = hostelRepossitory.findOne(id);
		return dbHostelDetails;

	}

	public HostelDetails approvalHostel(Long id) {
		HostelDetails hostelDetails = hostelRepository.findOne(id);
		if (hostelDetails == null) {
			throw new RuntimeException("no hostel found with this id" + id);
		}
		System.out.println(hostelDetails.getIsEnable());
		if (hostelDetails.getIsEnable() == false) {
			LoginDetails loginDetails = new LoginDetails();
			loginDetails.setUsername(hostelDetails.getEmailId());
			String password = passwordAutoGenerater();
			loginDetails.setPassword(passwordEncoder.encode(password));
			Role role = new Role();
			role.setId(1L);
			loginDetails.setRole(role);
			loginDetails.setHostelDetails(hostelDetails);
			// LoginDetails dbLoginDetails =
			// loginRepository.findByUsername(hostelDetails.getEmailId());
			/*
			 * if (dbLoginDetails != null) { throw new
			 * RuntimeException("User Already  registred"); }
			 */

			LoginDetails logindetails = loginRepository.save(loginDetails);
			if (logindetails != null) {
				hostelDetails.setEnable(true);
				hostelRepository.save(hostelDetails);
				try {
					MimeMessage message = emailSerice.sendMailtoHostel(logindetails, password);

					Transport.send(message);
				} catch (MessagingException e) {
					throw new RuntimeException("sdsd" + e);
				}
			}
		} else {
			throw new RuntimeException("Already Approved " + id);
		}
		return hostelDetails;
	}

	public String passwordAutoGenerater() {
		final String password = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz@#$%&_!~";
		SecureRandom rnd = new SecureRandom();
		StringBuilder sb = new StringBuilder(7);
		for (int i = 0; i < 5; i++)
			sb.append(password.charAt(rnd.nextInt(password.length())));
		return sb.toString();

	}

	public List<HostelDetails> hostelFilter(HostelFilterVO hostelFilterVO) {
		List<HostelDetails> finalDetails = new ArrayList<>();
		List<HostelDetails> lsDetails = hostelRepository.getCityState(hostelFilterVO.getFromCityName(),
				hostelFilterVO.getFromStateName(), hostelFilterVO.isTv());
		for (HostelDetails hostelDetails : lsDetails) {

			finalDetails.add(hostelDetails);

		}
		return lsDetails;
	}
}
