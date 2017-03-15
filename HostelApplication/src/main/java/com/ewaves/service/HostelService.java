package com.ewaves.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ewaves.domain.ResponseVO;
import com.ewaves.domain.RoomDetailsVO;
import com.ewaves.entities.HostelDetails;
import com.ewaves.entities.SharingDetails;
import com.ewaves.repository.HostelRepository;
import com.ewaves.util.HttpStatusCode;

@Service
public class HostelService {

	@Autowired
	private HostelRepository hostelRepossitory;
	@Autowired
	private EmailService emailSerice;

	@Autowired
	private SharingDetailsRepository sharingDetailsRepository;

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
			MimeMessage message = emailSerice.sendRequestMail(details);

			Transport.send(message);
		} catch (MessagingException e) {
			return HttpStatusCode.ALREADY_PHONENUM_EXISTS.getResponseVO("FAILURE");
		}
		return HttpStatusCode.CREATED.getResponseVO("SUCCESS");

	}

	public ResponseVO getAllHostels() {
		ResponseVO responseVO = new ResponseVO();
		List<HostelDetails> list = (List<HostelDetails>) hostelRepossitory.findAll();
		for (HostelDetails hostelDetails : list) {
			if (hostelDetails.getIsEnable() == true) {

				responseVO = HttpStatusCode.FOUND.getResponseVO("SUCCESS");
				responseVO.setResponseObjects(list);
			} else {
				responseVO = HttpStatusCode.NO_CONTENT.getResponseVO("No Hostel found");
			}
		}

		return responseVO;
	}

	/*
	 * public ResponseVO getAllHostels(String city, String state) { if
	 * (!(city.isEmpty()) && state.isEmpty()) {
	 * 
	 * return HttpStatusCode.NON_AUTHORITATIVE_INFORMATION.
	 * getResponseVO("city or state should not be empty"); } List<HostelDetails>
	 * hostelDetailsList = hostelRepossitory.findByCityAndState(city, state);
	 * 
	 * // HostelDetails cityStateList = hostelDetailsList.get(); if
	 * (hostelDetailsList != null) {
	 * 
	 * } ResponseVO responseVO = new ResponseVO(); responseVO =
	 * HttpStatusCode.FOUND.getResponseVO("SUCCESS");
	 * responseVO.setResponseObjects(hostelDetailsList);
	 * 
	 * return responseVO; }
	 */

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
				return HttpStatusCode.FOUND.getResponseVO("dfdfdf");
			}
			sharingDetails.setInsertedOn(LocalDateTime.now());
			sharingDetailList.add(sharingDetails);
		}

		sharingDetailsRepository.save(sharingDetailList);

		return HttpStatusCode.FOUND.getResponseVO("SUCCESS");
	}

}
