package com.saudeall.app.model.dto;

import lombok.Getter;

@Getter
public class GenderDTO {
    private final String value;
    private final String displayName;

    public GenderDTO(String value, String displayName) {
        this.value = value;
        this.displayName = displayName;
    }

}
