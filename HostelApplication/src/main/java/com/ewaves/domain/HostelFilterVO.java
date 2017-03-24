package com.ewaves.domain;

public class HostelFilterVO {

	private String fromCityName;
	private String fromStateName;
	private boolean tv;

	private boolean ac;
	private boolean nonVegetarian;
	private boolean washingMachine;
	private boolean hotWater;

	public String getFromCityName() {
		return fromCityName;
	}

	public void setFromCityName(String fromCityName) {
		this.fromCityName = fromCityName;
	}

	public String getFromStateName() {
		return fromStateName;
	}

	public void setFromStateName(String fromStateName) {
		this.fromStateName = fromStateName;
	}

	public boolean isTv() {
		return tv;
	}

	public void setTv(boolean tv) {
		this.tv = tv;
	}

	public boolean isAc() {
		return ac;
	}

	public void setAc(boolean ac) {
		this.ac = ac;
	}

	public boolean isNonVegetarian() {
		return nonVegetarian;
	}

	public void setNonVegetarian(boolean nonVegetarian) {
		this.nonVegetarian = nonVegetarian;
	}

	public boolean isWashingMachine() {
		return washingMachine;
	}

	public void setWashingMachine(boolean washingMachine) {
		this.washingMachine = washingMachine;
	}

	public boolean isHotWater() {
		return hotWater;
	}

	public void setHotWater(boolean hotWater) {
		this.hotWater = hotWater;
	}

	@Override
	public String toString() {
		return "HostelFilterVO [fromCityName=" + fromCityName + ", fromStateName=" + fromStateName + ", tv=" + tv
				+ ", ac=" + ac + ", nonVegetarian=" + nonVegetarian + ", washingMachine=" + washingMachine
				+ ", hotWater=" + hotWater + "]";
	}

}
