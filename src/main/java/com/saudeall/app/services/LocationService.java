package com.saudeall.app.services;

import com.saudeall.app.model.Location;
import com.saudeall.app.repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LocationService {
    private final LocationRepository locationRepository;

    public List<Location> getAll(){
        return locationRepository.findAll();
    }

    public void add(Location location){
        locationRepository.save(location);
    }

    public Location findById(UUID idOfLocation){
        return locationRepository.findById(idOfLocation);
    }

}
