package com.cg.event.repo;

import org.springframework.data.repository.CrudRepository;

import com.cg.event.model.Event;

public interface EventRepository extends CrudRepository<Event, Long> {

}
