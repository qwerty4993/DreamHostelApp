package com.ewaves.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ewaves.entities.Role;
import com.ewaves.service.RoleService;

@RestController
@RequestMapping(value = "/role")
public class RoleController {

	@Autowired
	private RoleService roleService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Role> getAllRoles() {
		return roleService.getAllRoles();
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void addRole(@RequestBody Role role) {
		roleService.addRole(role);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void updateRole(@PathVariable("id") Long id, @RequestBody Role role) {
		roleService.updateRole(id, role);
	}
}
