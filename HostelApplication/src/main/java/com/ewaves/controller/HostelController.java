package com.ewaves.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ewaves.domain.HostelCityStateVO;
import com.ewaves.domain.HostelFilterVO;
import com.ewaves.domain.ResponseVO;
import com.ewaves.domain.RoomDetailsVO;
import com.ewaves.entities.HostelDetails;
import com.ewaves.service.HostelService;

@RestController
@RequestMapping(value = "/hostel")
public class HostelController {

	@Autowired
	private HostelService hostelService;

	@RequestMapping(value = "/hostelrequest", method = RequestMethod.POST)
	public @ResponseBody ResponseVO hostelRequest(@RequestBody HostelDetails hostelDeails) {
		System.out.println("In usercontroller : \n " + hostelDeails.toString());
		ResponseVO responseVO = hostelService.hostelRequest(hostelDeails);
		return responseVO;

	}

	@RequestMapping(value = "/getAllHostels", method = RequestMethod.GET)
	public @ResponseBody ResponseVO getAllHostels() {
		ResponseVO responseVO = hostelService.getAllHostels();
		return responseVO;

	}

	@RequestMapping(value = "/getAllHostelsForApproval", method = RequestMethod.GET)
	public @ResponseBody List<HostelDetails> getAllHostelsForApproval() {
		return hostelService.getAllHostelsForApproval();

	}

	@RequestMapping(value = "/hostelDetails/{id}", method = RequestMethod.GET)
	public HostelDetails findHostelById(@PathVariable("id") Long id) {
		return hostelService.findHostelById(id);
	}

	@RequestMapping(value = "/getAllCityAndState", method = RequestMethod.POST)
	public @ResponseBody ResponseVO getHostelDetalsByStateAndCity(@RequestBody HostelCityStateVO requestVO) {
		ResponseVO responseVO = hostelService.getAllHostels1(requestVO.getCity(), requestVO.getState());
		return responseVO;

	}

	@RequestMapping(value = "/addroom", method = RequestMethod.POST)
	public @ResponseBody ResponseVO addRoom(@RequestBody RoomDetailsVO requestVO) {
		System.out.println("In addRoom ---->" + requestVO);
		ResponseVO responseVO = hostelService.addRoom(requestVO);
		return responseVO;

	}

	@RequestMapping(value = "/approvalStudent/{id}", method = RequestMethod.GET)
	public @ResponseBody HostelDetails approvalHostel(@PathVariable(value = "id") Long id, HttpServletRequest request) {
		System.out.println(id);

		return hostelService.approvalHostel(id, request);

	}

	@RequestMapping(value = "/hostelFilterVO", method = RequestMethod.POST)
	public @ResponseBody List<HostelDetails> HostelFilter(@RequestBody HostelFilterVO hostelFilterVO) {
		System.out.println(hostelFilterVO);
		List<HostelDetails> d = hostelService.hostelFilter(hostelFilterVO);

		return d;

	}

}
