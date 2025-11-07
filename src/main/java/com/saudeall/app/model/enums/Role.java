package com.saudeall.app.model.enums;

import lombok.Getter;

@Getter
public enum Role {
    USER("Patient"),
    STAFF("Staff"),
    DOCTOR("Doctor"),
    ADMIN("Admin");

    private final String roleName;

    Role(String roleName){
        this.roleName = roleName;
    }

    public static Role fromRoleName(String roleName) {
        for (Role role : Role.values()) {
            if (role.getRoleName().equalsIgnoreCase(roleName)) {
                return role;
            }
        }
        throw new IllegalArgumentException("Invalid role: " + roleName);
    }



}
