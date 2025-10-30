package com.saudeall.app.api;

import com.saudeall.app.model.Doctor;
import com.saudeall.app.model.StaffMember;
import com.saudeall.app.services.DoctorService;
import com.saudeall.app.services.StaffService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins="http://localhost:8100")
@RequestMapping("/api/v1/staff")
public class StaffController {
    private final StaffService staffService;
    private final DoctorService doctorService;

    @GetMapping
    public List<StaffMember> getAllStaffMembers(){ return staffService.getAll(); }

    @GetMapping(path = "/search/{role}")
    public List<StaffMember> getAllOfStaffRole(@PathVariable String role){
        return staffService.findByRole(role);
    }

    @PostMapping(path = "/create-doctor")
    public Doctor createDoctor(@RequestBody StaffMember newStaffMember){
        staffService.add(newStaffMember);
        StaffMember newlyCreatedStaffMember = staffService.findByEmail(newStaffMember.getEmail());
        Doctor newlyCreatedDoctor = new Doctor();

        //newlyCreatedDoctor.setEmail(newlyCreatedStaffMember.getEmail());
        newlyCreatedDoctor.setId(newlyCreatedStaffMember.getId());

        doctorService.add(newlyCreatedDoctor);
        return doctorService.findById(newStaffMember.getId());
    }
}
