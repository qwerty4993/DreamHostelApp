package com.ewaves.domain;

import java.util.List;

import com.ewaves.entities.SharingDetails;

public class RoomDetailsVO {

	private List<SharingDetails> sharingDetails;

	public List<SharingDetails> getSharingDetails() {
		return sharingDetails;
	}

	public void setSharingDetails(List<SharingDetails> sharingDetails) {
		this.sharingDetails = sharingDetails;
	}

	@Override
	public String toString() {
		return "RoomDetailsVO [sharingDetails=" + sharingDetails + "]";
	}

}
