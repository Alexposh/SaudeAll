package com.saudeall.app.model.dto;

import lombok.Getter;

@Getter
public class SpecializationDTO {
    private final String value;
    private final String displayName;

    public SpecializationDTO(String value, String displayName) {
        this.value = value;
        this.displayName = displayName;
    }
}
