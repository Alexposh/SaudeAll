package com.saudeall.app.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class AvailabilityDTO {
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
