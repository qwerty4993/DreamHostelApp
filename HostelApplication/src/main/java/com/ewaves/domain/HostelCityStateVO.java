package com.ewaves.domain;

public class HostelCityStateVO {
	private String city;
	private String state;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "HostelCityStateVO [city=" + city + ", state=" + state + "]";
	}

}
