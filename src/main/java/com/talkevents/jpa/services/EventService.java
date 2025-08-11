package com.talkevents.jpa.services;

import com.talkevents.jpa.dtos.SaveEventRecordDto;
import com.talkevents.jpa.entities.Attende;
import com.talkevents.jpa.entities.Event;
import com.talkevents.jpa.entities.Location;
import com.talkevents.jpa.repositories.AttendeRepository;
import com.talkevents.jpa.repositories.EventRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class EventService {

    private final EventRepository eventRepository;
    private final AttendeRepository attendeRepository;

    public EventService(EventRepository eventRepository, AttendeRepository attendeRepository) {
        this.eventRepository = eventRepository;
        this.attendeRepository = attendeRepository;
    }

    @Transactional
    public Event saveEvent(SaveEventRecordDto input) {
        var event = new Event();
        Set<Attende> attendes = new HashSet<>(attendeRepository.findAllById(input.attendes()));
        var location = new Location();

        location.setName(input.name());
        location.setAddress(input.location().address());
        location.setCapacity(input.location().capacity());

        event.setName(input.name());
        event.setDate(input.date());
        event.setAttendes(attendes);
        event.setLocation(location);

        return eventRepository.save(event);
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }
}
