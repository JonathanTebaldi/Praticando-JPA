package com.talkevents.jpa.dtos;

import java.util.UUID;

public record UpdateAttendeRecordDto(
        UUID id,
        String name,
        String email
) {
}
