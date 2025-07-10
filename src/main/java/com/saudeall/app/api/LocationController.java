package com.saudeall.app.api;

import com.saudeall.app.model.Location;
import com.saudeall.app.services.LocationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/locations")
public class LocationController {
    private final LocationService locationService;

    @GetMapping
    public List<Location> getLocations(){
        return locationService.getAll();
    }

    @GetMapping(path = "/location/{id}")
    public Location getSingleLocation(@PathVariable UUID id){
        return locationService.findById(id);
    }

    @PostMapping(path = "/location")
    public void createLocation(@RequestBody Location location){
        locationService.add(location);
    }

}
