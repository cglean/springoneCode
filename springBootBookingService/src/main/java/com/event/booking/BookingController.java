package com.event.booking;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.event.booking.model.Booking;
import com.event.booking.repo.BookingRepository;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

	@Autowired
	private BookingRepository repo;

	@RequestMapping("/greeting")
	public String greeting() {
		return "Hello from EurekaClient!";
	}

	@RequestMapping(value = { "/bookEvent/{userId}/{eventId}" }, method = RequestMethod.GET)
	public Booking bookEvent(@PathVariable("userId") Long userId, @PathVariable("eventId") Long eventId) {
		System.out.println("inside Book event" + eventId);
		Booking book = new Booking(userId, eventId , LocalDateTime.now().toString());
		book = repo.save(book);
		System.out.println(book);
		return book;
	}

	@RequestMapping(value = { "/deleteAllBookings" }, method = RequestMethod.GET)
	public String deleteAllBookings() {
		System.out.println("inside deleteAllBookings event");

		repo.deleteAll();
		return "DELETED";
	}
	
	@RequestMapping(value = { "/findAllBookingsForUser/{userId}" }, method = RequestMethod.GET)
	public List<Booking> findAllBookingsForUser(@PathVariable("userId") Long userId) {
		System.out.println("inside findAllBookings event");
		return repo.findByUserId(userId);
	}
}
