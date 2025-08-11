package com.talkevents.jpa.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "Event")
public class Event  implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private UUID id;
        @Column(nullable = false)
        private String name;
        @Column()
        private LocalDateTime date;
        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
        @OneToMany(mappedBy = "event", fetch = FetchType.LAZY)
        private Set<Session> sessions = new HashSet<>();
        @ManyToMany
        @JoinTable(
                name = "event_atendde",
                joinColumns = @JoinColumn(name = "event_id"),
                inverseJoinColumns = @JoinColumn(name = "attende_id")
        )
        private Set<Attende> attendes = new HashSet<>();

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Set<Session> getSessions() {
        return sessions;
    }

    public void setSessions(Set<Session> sessions) {
        this.sessions = sessions;
    }

    public Set<Attende> getAttendes() {
        return attendes;
    }

    public void setAttendes(Set<Attende> attendes) {
        this.attendes = attendes;
    }
}
