package com.ewaves.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ewaves.domain.ResponseVO;
import com.ewaves.entities.Role;
import com.ewaves.repository.RoleRepository;
import com.ewaves.util.HttpStatusCode;

@Service
public class RoleService {
	@Autowired
	private RoleRepository roleRepository;

	public ResponseVO addRole(Role role) {
		Role dbRole = roleRepository.findByName(role.getName());
		if (dbRole != null) {
			return HttpStatusCode.ROLE_ALREADY_EXISTS.getResponseVO("FAILURE");
		}
		roleRepository.save(role);
		return HttpStatusCode.CREATED.getResponseVO("SUCCESS");

	}

}
