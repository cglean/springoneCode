package com.cg.event.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(nullable = false, unique = true)
	private String name;
	@Column
	private String category;
	@Column
	private LocalDateTime eventTime;
	
	public Event() {
		
	}

	public Event(long id, String name, String category, LocalDateTime eventTime) {

		this.id = id;
		this.name = name;
		this.category = category;
		this.eventTime = eventTime;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public LocalDateTime getEventTime() {
		return eventTime;
	}

	public void setEventTime(LocalDateTime eventTime) {
		this.eventTime = eventTime;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", name=" + name + ", category=" + category + ", eventTime=" + eventTime + "]";
	}

}
