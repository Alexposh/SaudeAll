package com.saudeall.app.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@AllArgsConstructor
@Getter
public class KeyValueId {
    private UUID id;
    private String field;
    private String value;
}
