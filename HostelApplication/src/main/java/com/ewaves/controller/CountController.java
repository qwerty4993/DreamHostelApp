package com.ewaves.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ewaves.domain.CounttVO;
import com.ewaves.service.CountService;

@RestController
@RequestMapping("/count")
public class CountController {
	@Autowired
	private CountService CountService;
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public CounttVO getAllCount() {
		return CountService.getAllCount();
	}

}
