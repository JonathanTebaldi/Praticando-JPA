package com.talkevents.jpa.entities;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Time;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "Session")
public class Session implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false, length = 300)
    private String title;
    @Column(nullable = false)
    private Time startTime;
    @Column(nullable = false)
    private Time endTime;
    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;
    @ManyToMany
    @JoinTable(
            name = "session_attende",
            joinColumns = @JoinColumn(name = "sessioId"),
            inverseJoinColumns = @JoinColumn(name = "attendeId")
    )
    private Set<Attende> attendes = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "speakerId")
    private Speaker speaker;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public Event getEvent() {
        return event;
    }

    public Set<Attende> getAttendes() {
        return attendes;
    }

    public void setAttendes(Set<Attende> attendes) {
        this.attendes = attendes;
    }

    public Speaker getSpeaker() {
        return speaker;
    }

    public void setSpeaker(Speaker speaker) {
        this.speaker = speaker;
    }
}
