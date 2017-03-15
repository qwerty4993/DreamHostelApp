package com.ewaves.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ewaves.domain.ResponseVO;
import com.ewaves.entities.Role;
import com.ewaves.service.RoleService;

@RestController

public class RoleController {

	@Autowired
	private RoleService roleService;

	@RequestMapping(value = "/addRole", method = RequestMethod.POST)
	public @ResponseBody ResponseVO addRole(@RequestBody Role roleDeails) {
		System.out.println("In RoleController :\n " + roleDeails.toString());

		ResponseVO responseVO = roleService.addRole(roleDeails);

		return responseVO;

	}

}
