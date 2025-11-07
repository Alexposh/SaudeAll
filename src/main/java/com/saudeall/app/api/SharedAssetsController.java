package com.saudeall.app.api;

import com.saudeall.app.model.dto.GenderDTO;
import com.saudeall.app.model.dto.SpecializationDTO;
import com.saudeall.app.model.enums.Gender;
import com.saudeall.app.model.enums.Specialization;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/shared")
@CrossOrigin(origins="http://localhost:8100")
public class SharedAssetsController {

    @GetMapping(path="/genders")
    public List<GenderDTO> getGenders() {
        return Arrays.stream(Gender.values())
                .map(gender -> new GenderDTO(gender.name(), gender.getDisplayName()))
                .collect(Collectors.toList());
    }

    @GetMapping(path="/specializations")
    public List<SpecializationDTO> getSpecialities(){
        return Arrays.stream(Specialization.values())
                .map(specialization -> new SpecializationDTO(specialization.name(), specialization.getDisplayName()))
                .collect(Collectors.toList());
    }
}
