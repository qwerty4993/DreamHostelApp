package com.ewaves.domain;

public class StudentRequestVO {

	private Long sudentId;
	private Long hostelId;
	private String name;
	private String email;
	private String sharingPerference;
	private String noOfBeds;

	public Long getSudentId() {
		return sudentId;
	}

	public void setSudentId(Long sudentId) {
		this.sudentId = sudentId;
	}

	public Long getHostelId() {
		return hostelId;
	}

	public void setHostelId(Long hostelId) {
		this.hostelId = hostelId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSharingPerference() {
		return sharingPerference;
	}

	public void setSharingPerference(String sharingPerference) {
		this.sharingPerference = sharingPerference;
	}

	public String getNoOfBeds() {
		return noOfBeds;
	}

	public void setNoOfBeds(String noOfBeds) {
		this.noOfBeds = noOfBeds;
	}

}
