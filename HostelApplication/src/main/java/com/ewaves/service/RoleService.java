package com.ewaves.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ewaves.domain.Feature;
import com.ewaves.entities.Role;
import com.ewaves.repository.RoleRepository;

@Service
public class RoleService {
	@Autowired
	private RoleRepository roleRepository;

	public void addRole(Role role) {
		Role dbRole = roleRepository.findByName(role.getName());
		if (dbRole != null) {
			throw new RuntimeException("Roll Already Exist");

		}
		for (Feature feature : role.getFeatures()) {
			feature.setRole(role);

		}

		roleRepository.save(role);

	}

	public List<Role> getAllRoles() {
		return (List<Role>) roleRepository.findAll();
	}
	public void updateRole(Long id, Role role) {
		Role theRole = roleRepository.findById(role.getId());

		if (theRole == null) {
			throw new RuntimeException("roll #[" + role.getName()
					+ "] finns inte.");
		}
		Role dbRole = roleRepository.findByName(role.getName());

		if (dbRole != null && dbRole.getId() != role.getId()) {
			throw new RuntimeException("Rollen kan inte uppdateras!!");

		}
		theRole.setName(role.getName());
		theRole.setDisplayName(role.getDisplayName());
		theRole.getFeatures().clear();
		theRole.getFeatures().addAll(role.getFeatures());

		for (Feature feature : theRole.getFeatures()) {
			feature.setRole(theRole);
		}

		roleRepository.save(theRole);

	}

}
