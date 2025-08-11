package com.talkevents.jpa.services;

import com.talkevents.jpa.dtos.SaveAttendeRecordDto;
import com.talkevents.jpa.dtos.UpdateAttendeRecordDto;
import com.talkevents.jpa.entities.Attende;
import com.talkevents.jpa.repositories.AttendeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AttendeService {
    private final AttendeRepository attendeRepository;

    public AttendeService(AttendeRepository attendeRepository) {
        this.attendeRepository = attendeRepository;
    }

    public Attende saveAttende(SaveAttendeRecordDto input) {
        var attende = new Attende();

        attende.setName(input.name());
        attende.setEmail(input.email());

        return attendeRepository.save(attende);
    }

    public void updateAttende(UpdateAttendeRecordDto input) {
        var attende = attendeRepository.findById(input.id()).orElseThrow(() -> new EntityNotFoundException("Attendee not found"));

        attende.setName(input.name());
        attende.setEmail(input.email());

        attendeRepository.save(attende);
    }

    public void deleteAttende(UUID id) {
        var attende = attendeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Attendee not found"));
        attendeRepository.delete(attende);
    }

    public Attende getAttende(UUID id) {
        return attendeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Attendee not found"));
    }

    public List<Attende> getAllAttendes() {
        return attendeRepository.findAll();
    }

}
