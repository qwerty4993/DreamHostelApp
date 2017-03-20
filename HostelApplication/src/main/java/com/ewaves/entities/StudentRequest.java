package com.ewaves.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.ewaves.converter.LocalDateConverter;
import com.ewaves.converter.LocalDateDeserializer;
import com.ewaves.converter.LocalDateSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
public class StudentRequest implements Serializable {

	private static final long serialVersionUID = 3536384242164351894L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private String email;
	private String sharingPerference;
	private String noOfBeds;
	private Date insertedOn;
	private Date UpdatedOn;
	private Boolean isApproval;
	
	@ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
	private HostelDetails hostelDetails;

	@OneToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
	private Student student;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	@Convert(converter = LocalDateConverter.class)
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	public Date getInsertedOn() {
		return insertedOn;
	}

	public void setInsertedOn(Date insertedOn) {
		this.insertedOn = insertedOn;
	}

	@Convert(converter = LocalDateConverter.class)
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	public Date getUpdatedOn() {
		return UpdatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		UpdatedOn = updatedOn;
	}

	public HostelDetails getHostelDetails() {
		return hostelDetails;
	}

	public void setHostelDetails(HostelDetails hostelDetails) {
		this.hostelDetails = hostelDetails;
	}

	public Boolean getIsApproval() {
		return isApproval;
	}

	public void setIsApproval(Boolean isApproval) {
		this.isApproval = isApproval;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "StudentRequest [id=" + id + ", name=" + name + ", email=" + email + ", sharingPerference="
				+ sharingPerference + ", noOfBeds=" + noOfBeds + ", insertedOn=" + insertedOn + ", UpdatedOn="
				+ UpdatedOn + ", isApproval=" + isApproval + ", hostelDetails=" + hostelDetails + ", student=" + student
				+ "]";
	}

}
