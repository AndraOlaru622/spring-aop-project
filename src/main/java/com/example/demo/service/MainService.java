package com.example.demo.service;

import com.example.demo.model.DriverLocation;
import com.example.demo.model.DriverVehicle;
import com.example.demo.model.LinePrice;
import com.example.demo.model.VehicleLine;
import com.example.demo.repository.MainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainService {
    @Autowired
    private MainRepository mainRepository;


    public List<DriverLocation> getDriverLocation() {
        return mainRepository.getDriverLocations();
    }

    public List<DriverVehicle> getDriverVehicle() {
        return mainRepository.getDriverVehicles();
    }

    public List<VehicleLine> getVehicleLine() {
        return mainRepository.getVehicleLines();
    }

    public List<LinePrice> getLinePrice() {
        return mainRepository.getLinesPrice();
    }
}
