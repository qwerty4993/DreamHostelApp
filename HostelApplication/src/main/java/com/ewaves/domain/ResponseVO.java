
package com.ewaves.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ResponseVO {

	private String status;
	private int statusCode;
	private String statusDesc;
	private List<Object> responseObject;
	private Object responseObjects;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusDesc() {
		return statusDesc;
	}

	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}

	public List<Object> getResponseObject() {
		return responseObject;
	}

	public void setResponseObject(List<Object> responseObject) {
		this.responseObject = responseObject;
	}

	public Object getResponseObjects() {
		return responseObjects;
	}

	public void setResponseObjects(Object responseObjects) {
		this.responseObjects = responseObjects;
	}

}
