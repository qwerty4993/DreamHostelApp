package com.ewaves.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @author Ewaves@Test
 *
 */
@Entity
public class SharingDetails implements Serializable {

	private static final long serialVersionUID = 3917958235490067667L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private Integer sharingType;
	private Integer noOfPersonAvailability;
	private Date insertedOn;
	private Date UpdatedOn;
	@ManyToOne(cascade = CascadeType.ALL)
	private HostelDetails hostelDetails;
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

	public Date getInsertedOn() {
		return insertedOn;
	}

	public void setInsertedOn(Date insertedOn) {
		this.insertedOn = insertedOn;
	}

	public Date getUpdatedOn() {
		return UpdatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		UpdatedOn = updatedOn;
	}

}
