package com.event.booking.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false)
	private long userId;
	@Column(nullable = false)
	private long eventId;
	
	@Column
	private String eventTime;
	
	public Booking() {
		
	}
	
	
	public Booking(long userId, long eventId, String eventTime) {
		this.userId = userId;
		this.eventId = eventId;
		this.eventTime = eventTime;
	}


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getEventId() {
		return eventId;
	}
	public void setEventId(long eventId) {
		this.eventId = eventId;
	}

	public String getEventTime() {
		return eventTime;
	}

	public void setEventTime(String eventTime) {
		this.eventTime = eventTime;
	}


	@Override
	public String toString() {
		return "Booking [id=" + id + ", userId=" + userId + ", eventId=" + eventId + ", eventTime=" + eventTime + "]";
	}

	
	
	
	
	

}
