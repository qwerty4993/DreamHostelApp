package com.ewaves.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.ewaves.converter.LocalDateConverter;
import com.ewaves.converter.LocalDateDeserializer;
import com.ewaves.converter.LocalDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
public class SharingDetails implements Serializable {

	private static final long serialVersionUID = 3917958235490067667L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private Integer sharingType;
	private Integer noOfPersonAvailability;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	private HostelDetails hostelDetails;

	private LocalDateTime insertedOn;
	private LocalDateTime UpdatedOn;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSharingType() {
		return sharingType;
	}

	public void setSharingType(Integer sharingType) {
		this.sharingType = sharingType;
	}

	public HostelDetails getHostelDetails() {
		return hostelDetails;
	}

	public void setHostelDetails(HostelDetails hostelDetails) {
		this.hostelDetails = hostelDetails;
	}

	public Integer getNoOfPersonAvailability() {
		return noOfPersonAvailability;
	}

	public void setNoOfPersonAvailability(Integer noOfPersonAvailability) {
		this.noOfPersonAvailability = noOfPersonAvailability;
	}

	@Convert(converter = LocalDateConverter.class)
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	public LocalDateTime getInsertedOn() {
		return insertedOn;
	}

	public void setInsertedOn(LocalDateTime insertedOn) {
		this.insertedOn = insertedOn;
	}

	@Convert(converter = LocalDateConverter.class)
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	public LocalDateTime getUpdatedOn() {
		return UpdatedOn;
	}

	public void setUpdatedOn(LocalDateTime updatedOn) {
		UpdatedOn = updatedOn;
	}

	@Override
	public String toString() {
		return "SharingDetails [id=" + id + ", sharingType=" + sharingType + ", noOfPersonAvailability="
				+ noOfPersonAvailability + ", hostelDetails=" + hostelDetails + ", insertedOn=" + insertedOn
				+ ", UpdatedOn=" + UpdatedOn + "]";
	}

}
