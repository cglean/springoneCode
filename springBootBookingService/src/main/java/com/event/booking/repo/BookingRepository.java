package com.event.booking.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.event.booking.model.Booking;

public interface BookingRepository extends CrudRepository<Booking, Long>  {

	
	List<Booking> findByUserId(long id);
}
