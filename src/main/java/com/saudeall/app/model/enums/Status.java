package com.saudeall.app.model.enums;

import lombok.Getter;

@Getter
public enum Status {
    REQUESTED("Requested"),
    CONFIRMED("Confirmed"),
    CANCELLED("Cancelled"),
    PATIENT_ARRIVED("Patient arrived"),
    ONGOING("Ongoing"),
    COMPLETED("Completed"),
    PAID("Paid");

    private final String displayName;

    Status(String displayName){this.displayName = displayName;}

    public static Status fromDisplayName(String displayName){
        for(Status status : Status.values()){
            if(status.getDisplayName().equalsIgnoreCase(displayName)){
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid specialization:" + displayName);
    }
}
