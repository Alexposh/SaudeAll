package com.saudeall.app.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Patient extends Person{
    private String IBAN;
    private String contactDetails;
}
