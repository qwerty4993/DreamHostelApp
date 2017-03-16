package com.ewaves.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Access(AccessType.PROPERTY)
public class Student implements java.io.Serializable {

	private static final long serialVersionUID = -4581283824375799719L;

	private Long id;

	private String firstName;
	private String lastName;
	private String phone;

	private String email;

	private String address;

	private Date insertedOn;

	private Date modifiedOn;

	private LoginDetails user;
	@JsonIgnore
	private StudentRequest studentRequests;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "email", length = 45)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "address", length = 200)
	public String getAddress() {
		return this.address;
	}

	@Column(name = "phone", length = 45)
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "student")
	public LoginDetails getUser() {
		return user;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "insertedOn", length = 0)
	public Date getInsertedOn() {
		return insertedOn;
	}

	public void setInsertedOn(Date insertedOn) {
		this.insertedOn = insertedOn;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modifiedOn", length = 0)
	public Date getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setUser(LoginDetails user) {
		this.user = user;
	}

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "student")
	public StudentRequest getStudentRequests() {
		return studentRequests;
	}

	public void setStudentRequests(StudentRequest studentRequests) {
		this.studentRequests = studentRequests;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	

}
