package com.cg.event.model;

import java.time.LocalDateTime;

public class EventBooking {

	private String eventName;
	private LocalDateTime eventTime;
	private LocalDateTime bookingDate;
	
	public EventBooking() {
		
	}
	public EventBooking(String eventName, LocalDateTime eventTime, LocalDateTime bookingDate) {
		super();
		this.eventName = eventName;
		this.eventTime = eventTime;
		this.bookingDate = bookingDate;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public LocalDateTime getEventTime() {
		return eventTime;
	}
	public void setEventTime(LocalDateTime eventTime) {
		this.eventTime = eventTime;
	}
	public LocalDateTime getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(LocalDateTime bookingDate) {
		this.bookingDate = bookingDate;
	}
	
	
	
}
