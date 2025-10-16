package com.saudeall.app.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class AvailabilityDTO {
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
