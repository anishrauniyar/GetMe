package org.getme.project.model;

import java.sql.Date;

public class SenderReceiverModel {

	private String srid;
	private String senderUsername;
	private String receiverUsername;
	private String senderLatitude;
	private String senderLongitude;
	private String senderTitle;
	private String senderDescription;
	private Date sendDate;
	
	public String getSrid() {
		return srid;
	}
	public void setSrid(String srid) {
		this.srid = srid;
	}
	
	public String getSenderUsername() {
		return senderUsername;
	}
	public void setSenderUsername(String senderUsername) {
		this.senderUsername = senderUsername;
	}
	
	public String getReceiverUsername() {
		return receiverUsername;
	}
	public void setReceiverUsername(String receiverUsername) {
		this.receiverUsername = receiverUsername;
	}
	
	public String getSenderLatitude() {
		return senderLatitude;
	}
	public void setSenderLatitude(String senderLatitude) {
		this.senderLatitude = senderLatitude;
	}
	
	public String getSenderLongitude() {
		return senderLongitude;
	}
	public void setSenderLongitude(String senderLongitude) {
		this.senderLongitude = senderLongitude;
	}
	
	public String getSenderTitle() {
		return senderTitle;
	}
	public void setSenderTitle(String senderTitle) {
		this.senderTitle = senderTitle;
	}
	
	public String getSenderDescription() {
		return senderDescription;
	}
	public void setSenderDescription(String senderDescription) {
		this.senderDescription = senderDescription;
	}
	
	public Date getSendDate() {
		return sendDate;
	}
	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}
	
}
