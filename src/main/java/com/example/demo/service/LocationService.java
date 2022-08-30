package com.example.demo.service;

import com.example.demo.model.Location;
import com.example.demo.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;


    public List<Location> getLocations() {
        return locationRepository.getLocations();
    }

    public List<Location> addLocation(Location p) {
        return locationRepository.addLocation(p);
    }

    public List<Location> deleteLocationById(int id) {
        return locationRepository.deleteLocationById(id);
    }
}
