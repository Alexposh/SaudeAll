package com.saudeall.app.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class LoginData {
    String email;
    String password;
}
