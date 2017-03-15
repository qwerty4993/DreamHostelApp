package com.ewaves.domain;

public enum RoleType {
	USERID("1"), USER("USER"), HOSTEL_MANAGER("HOSTEL_MANAGER");
	String roleType;

	private RoleType(String roleType) {
		this.roleType = roleType;

	}

	public String getRoleType() {
		return roleType;
	}

}