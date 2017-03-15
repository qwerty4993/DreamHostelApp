package com.ewaves.util;

import com.ewaves.domain.ResponseVO;

public enum HttpStatusCode {

	
	OK(200, "OK"),
	CREATED(201, "Created"),
    ACCEPTED(202, "Accepted"),
    NON_AUTHORITATIVE_INFORMATION(203, "Non-Authoritative Information"),
    NO_CONTENT(204,  "No Content"),
    RESET_CONTENT(205, "Reset Content"),
    PARTIAL_CONTENT(206, "Partial Content"),
    MULTI_STATUS(207, "Multi-Status (WebDAV; RFC 4918"),
    ALREADY_REPORTED(208, "Already Reported (WebDAV; RFC 5842)"),
    IM_USED(226, "IM Used (RFC 3229)"),
    ALREADY_USERNAME_EXISTS(208, "Already Registered with same UserName"),
    ALREADY_PHONENUM_EXISTS(208, "Already Registered with same Phone Number"),
    ALREADY_EMAIL_EXISTS(208, "Already Registered with same Email"),
    ROLE_ALREADY_EXISTS(208, "Role already Exists"),
    CLAIM_COUNT_EXCEEDED(208, "Claim Count Exceeded"),
    CLAIM_REVERTED_FAILURE(208, "Claim Revert Failure"),
    CLAIM_REVERTED_SUCCESSFULLY(209, "Claim Reverted Successfully"),
    UPDATED_SUCCESSFULLY(210,"Password Updated Successfully"),
	
	FOUND(302, "Successfully Saved"),
	
	BAD_REQUEST(400, "Bad Request"),
	UNAUTHORIZED(401, "Unauthorized"),
	BAD_GATEWAY(502, "Bad Gateway"), TOKEN_INVALID (497,"Token is invalid"),
    TOKEN_EXPIRED (498,"Token is Expired");

	private int code;
	private String desc;
	private String text;
	private ResponseVO responseVO;

	HttpStatusCode(int code, String desc) {
		this.code = code;
		this.desc = desc;
		this.text = Integer.toString(code);

	}

	
	public int getCode() {
		return code;
	}

	
	public String asText() {
		return text;
	}

	
	public String getDesc() {
		return desc;
	}

	
	public void setResponseVO(ResponseVO responseVO) {
		this.responseVO = responseVO;
	}

	
	public ResponseVO getResponseVO(String status) {
		System.out.println(this.code);
		responseVO = new ResponseVO();
		responseVO.setStatus(status);
		responseVO.setStatusCode(this.code);
		responseVO.setStatusDesc(this.desc);

		return responseVO;
	}

}
