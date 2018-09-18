package com.cg.event.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class EventForm {
	
	private String eventName;
	private String eventCategory;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date eventTime;
	
	public EventForm() {
		
	}
	
	
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getEventCategory() {
		return eventCategory;
	}
	public void setEventCategory(String eventCategory) {
		this.eventCategory = eventCategory;
	}

	public Date getEventTime() {
		return eventTime;
	}

	public void setEventTime(Date eventTime) {
		this.eventTime = eventTime;
	}


	public EventForm(String eventName, String eventCategory, Date eventTime) {
		super();
		this.eventName = eventName;
		this.eventCategory = eventCategory;
		this.eventTime = eventTime;
	}
	

}
