package com.cg.event.controller;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cg.event.model.Booking;

@FeignClient("event-booking-service")
public interface BookingService {

	@RequestMapping("/api/bookings/greeting")
	String greeting();

	@RequestMapping(method = RequestMethod.GET, value = "/api/bookings/bookEvent/{userId}/{eventId}")
	Booking bookEvent(@PathVariable("userId") Long userId, @PathVariable("eventId") Long eventId);

	@RequestMapping(value = { "/api/bookings/findAllBookingsForUser/{userId}" }, method = RequestMethod.GET)
	List<Booking> findAllBookings(@PathVariable("userId") Long userId);
}
