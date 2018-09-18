package com.cg.event.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cg.event.model.Booking;
import com.cg.event.model.Event;
import com.cg.event.model.EventBooking;
import com.cg.event.model.EventForm;
import com.cg.event.repo.EventRepository;

@Controller
@RequestMapping("/api/events")
public class EventController {

	@Autowired
	private EventRepository eventRepository;
	
	@Autowired
	private BookingService bookingservice;

	@RequestMapping(value = { "/eventList" }, method = RequestMethod.GET)
	public String findAll(Model model) {
		System.out.println("inside find all");
		List<Event> eventList = (List<Event>) eventRepository.findAll();
		if ( eventList == null || (eventList != null && eventList.size() == 0)) {
			eventList = new ArrayList<Event>();
			eventList.add(new Event(1l, "Spring Event 1", "SpringBoot", LocalDateTime.now()));
			eventList.add(new Event(2l, "Spring Event 2", "SpringCloud", LocalDateTime.now()));
			eventList.forEach(e -> System.out.println(e));
			eventRepository.saveAll(eventList);
		}
		
		model.addAttribute("events", eventList);
		
		return "listEvent";
	}

	@GetMapping("/{id}")
	public Event findOne(@PathVariable Long id) {
		return eventRepository.findById(id).get();
	}


    @RequestMapping(value = { "/addEvent" }, method = RequestMethod.GET)
    public String showAddEventPage(Model model) {
    	
    	System.out.println("inside addEvent get ");
    	EventForm eventForm = new EventForm();
        model.addAttribute("eventForm", eventForm);
 
        return "addEvent";
    }
    
	@RequestMapping(value = { "/addEvent" }, method = RequestMethod.POST)
    public String savePerson(Model model, //
            @ModelAttribute("eventForm") EventForm eventForm , BindingResult bindingResult) {
		System.out.println("inside addEvent post");
        String name = eventForm.getEventName();
        String category = eventForm.getEventCategory();
        System.out.println("Event Time is " + eventForm.getEventTime());

        LocalDateTime eventTime = null;
        if(eventForm.getEventTime() != null) {
        	eventTime = convertToLocalDateTimeViaInstant(eventForm.getEventTime());
        }else {
        	eventTime = LocalDateTime.now();
        }
        
        if (name != null && name.length() > 0 //
                && category != null && category.length() > 0) {
        	long count = eventRepository.count();
        	System.out.println("present count" + count);
        	Event newEvent = new Event(count+1 , name, category , eventTime);
        	eventRepository.save(newEvent);
 
            return "redirect:/api/events/eventList";
        }
 
        model.addAttribute("errorMessage", "Unable to Add Event");
        return "addEvent";
    }
 
	@RequestMapping(value = { "/bookEvent" }, method = RequestMethod.GET)
	public String bookEvent(@RequestParam("id")Long id , Model model) {
		System.out.println("inside Book event" + id);
		Booking booked = bookingservice.bookEvent(1l, id);
		if(booked == null ) {
			model.addAttribute("errorMessage", "Unable to do booking");
		}
		
        return "redirect:/api/events/listBookings";
	}
	
	@RequestMapping(value = { "/listBookings" }, method = RequestMethod.GET)
	public String listBookings(Model model) {
		
		List<Booking> bookings = bookingservice.findAllBookings(1l);
		System.out.println("bookings" + bookings);
		List<EventBooking> eventBooking = new ArrayList<EventBooking>();
		bookings.forEach(b -> {
			Event ev = eventRepository.findById(new Long(b.getEventId())).get();
			if(ev != null) {
				System.out.println("event" + ev);
				EventBooking evb = new EventBooking();
				evb.setBookingDate(b.getEventTime());
				evb.setEventName(ev.getName());
				evb.setEventTime(ev.getEventTime());
				eventBooking.add(evb);
			}
		});
		
		model.addAttribute("bookings", eventBooking);
		
		return "listBookings";
	}

	@GetMapping("/deleteEvent")
	public String delete(@RequestParam("id")String id) {
		eventRepository.deleteById(Long.parseLong(id));
		 return "redirect:/api/events/eventList";
	}

	@PutMapping("/{id}")
	public Event updateEvent(@RequestBody Event event, @PathVariable Long id) {
		return eventRepository.save(event);
	}
	
	private LocalDateTime convertToLocalDateTimeViaInstant(Date dateToConvert) {
	    return dateToConvert.toInstant()
	      .atZone(ZoneId.systemDefault())
	      .toLocalDateTime();
	}

}
