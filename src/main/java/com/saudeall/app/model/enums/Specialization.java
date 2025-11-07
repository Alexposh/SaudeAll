package com.saudeall.app.model.enums;

import lombok.Getter;

@Getter
public enum Specialization {
    GENERAL_MEDICINE("General Medicine"),
    PEDIATRICS("Pediatrics"),
    PSYCHIATRY("Psychiatry"),
    DERMATOLOGY("Dermatology"),
    CARDIOLOGY("Cardiology"),
    ONCOLOGY("Oncology"),
    NEUROLOGY("Neurology");

    private final String displayName;

    Specialization(String displayName) {
        this.displayName = displayName;
    }

    public static Specialization fromDisplayName(String displayName) {
        for (Specialization specialization : Specialization.values()) {
            if (specialization.getDisplayName().equalsIgnoreCase(displayName)) {
                return specialization;
            }
        }
        throw new IllegalArgumentException("Invalid specialization: " + displayName);
    }


}
