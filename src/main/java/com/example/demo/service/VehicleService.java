package com.example.demo.service;

import com.example.demo.model.Driver;
import com.example.demo.model.Vehicle;
import com.example.demo.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;


    public List<Vehicle> getVehicles() {
        return vehicleRepository.getVehicles();
    }

    public List<Vehicle> addVehicle(Vehicle p) {
        return vehicleRepository.addVehicle(p);
    }

    public List<Vehicle> deleteVehicleById(int id) {
        return vehicleRepository.deleteVehicleById(id);
    }
}
