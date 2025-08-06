package com.talkevents.jpa.entities;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
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

}
