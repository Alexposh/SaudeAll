package com.saudeall.app.model.enums;

import lombok.Getter;

@Getter
public enum Permission {
    CREATE("Create"),
    READ( "Read"),
    UPDATE( "Update"),
    DELETE("Delete");

        private final String displayName;

    Permission(String displayName){ this.displayName = displayName; }

    public static Permission fromDisplayName(String displayName) {
        for (Permission permission : Permission.values()) {
            if (permission.getDisplayName().equalsIgnoreCase(displayName)) {
                return permission;
            }
        }
        throw new IllegalArgumentException("Invalid permission: " + displayName);
    }
}
