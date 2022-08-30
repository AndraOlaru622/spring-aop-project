package com.example.demo.controller;


import com.example.demo.model.DriverLocation;
import com.example.demo.model.DriverVehicle;
import com.example.demo.model.LinePrice;
import com.example.demo.model.VehicleLine;
import com.example.demo.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class MainController {
    @Autowired
    private MainService mainService;


    @GetMapping("/getDriverLocation")
    public List<DriverLocation> getDriverLocation() {
        return mainService.getDriverLocation();
    }

    @GetMapping("/getDriverVehicle")
    public List<DriverVehicle> getDriverVehicle() {
        return mainService.getDriverVehicle();
    }

    @GetMapping("/getVehicleLine")
    public List<VehicleLine> getVehicleLine() {
        return mainService.getVehicleLine();
    }

    @GetMapping("/getLinePrice")
    public List<LinePrice> getLinePrice() {
        return mainService.getLinePrice();
    }
}
