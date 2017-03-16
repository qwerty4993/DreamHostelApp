package com.ewaves.domain;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.ewaves.entities.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Access(AccessType.PROPERTY)
public class Feature implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String name;

	private String description;

	private Boolean allowRead;

	private Boolean allowCreate;

	private Boolean allowEdit;

	private Boolean allowDelete;

	private Role role;

	public Feature() {
	}

	public Feature(String name, String description) {
		this.name = name;
		this.description = description;
	}

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getAllowRead() {
		return allowRead;
	}

	public void setAllowRead(Boolean allowRead) {
		this.allowRead = allowRead;
	}

	public Boolean getAllowCreate() {
		return allowCreate;
	}

	public void setAllowCreate(Boolean allowCreate) {
		this.allowCreate = allowCreate;
	}

	public Boolean getAllowEdit() {
		return allowEdit;
	}

	public void setAllowEdit(Boolean allowEdit) {
		this.allowEdit = allowEdit;
	}

	public Boolean getAllowDelete() {
		return allowDelete;
	}

	public void setAllowDelete(Boolean allowDelete) {
		this.allowDelete = allowDelete;
	}

	@JsonIgnore
	@ManyToOne(cascade = CascadeType.MERGE)
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	

	
	@Transient
	public Boolean getAllowAccess() {
		if (allowRead != null && allowRead == true && allowCreate != null
				&& allowCreate == true && allowEdit != null
				&& allowEdit == true && allowDelete != null
				&& allowDelete == true) {
			return true;
		} else {
			return false;
		}
	}
	

}
