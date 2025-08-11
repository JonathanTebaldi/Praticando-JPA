package com.talkevents.jpa.controllers;

import com.talkevents.jpa.dtos.SaveAttendeRecordDto;
import com.talkevents.jpa.dtos.UpdateAttendeRecordDto;
import com.talkevents.jpa.entities.Attende;
import com.talkevents.jpa.services.AttendeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/attende")
public class AttendeController {
    private final AttendeService attendeService;

    public AttendeController(AttendeService attendeService) {
        this.attendeService = attendeService;
    }

    @PostMapping
    public ResponseEntity<Attende> saveAttende(@RequestBody SaveAttendeRecordDto input) {
        return ResponseEntity.status(HttpStatus.CREATED).body(attendeService.saveAttende(input));
    }

    @PutMapping
    public ResponseEntity<Void> updateAttende(@RequestBody UpdateAttendeRecordDto input) {
        attendeService.updateAttende(input);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAttende(@PathVariable UUID id) {
        attendeService.deleteAttende(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Attende>> getAllAttendees() {
        return ResponseEntity.ok(attendeService.getAllAttendes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Attende> getAttendeeById(@PathVariable UUID id) {
        return ResponseEntity.ok(attendeService.getAttende(id));
    }
}
