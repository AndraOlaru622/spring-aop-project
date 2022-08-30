package com.example.demo;


import com.example.demo.model.DriverLocation;
import com.example.demo.model.DriverVehicle;
import com.example.demo.model.LinePrice;
import com.example.demo.model.VehicleLine;
import com.example.demo.repository.MainRepository;
import com.example.demo.service.MainService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MainServiceTest {

    @InjectMocks
    private MainService mainService;

    @Mock
    private MainRepository mainRepository;

    @Test
    @DisplayName("Retrieve all drivers location")
    public void getDriverLocationTest(){
        //arrange
        when(mainRepository.getDriverLocations()).thenReturn(
                Arrays.asList(new DriverLocation(1,"Dan", "Popa", "Buzau", "Romania"))
        );

        //act
        List<DriverLocation> result = mainService.getDriverLocation();

        //assert
        DriverLocation dl = result.get(0);
        assertEquals(result.size(), 1);
        assertEquals(dl.getFirst_name(), "Dan");
        assertEquals(dl.getLast_name(), "Popa");
        assertEquals(dl.getCity(), "Buzau");
        assertEquals(dl.getCountry(), "Romania");

    }

    @Test
    @DisplayName("Retrieve all drivers vehicle")
    public void getDriverVehicleTest(){
        //arrange
        when(mainRepository.getDriverVehicles()).thenReturn(
                Arrays.asList(new DriverVehicle(1, "Dan", "Popa","Audi", "Audi"))
        );

        //act
        List<DriverVehicle> result = mainService.getDriverVehicle();

        //assert
        DriverVehicle dv = result.get(0);
        assertEquals(result.size(), 1);
        assertEquals(dv.getFirst_name(), "Dan");
        assertEquals(dv.getLast_name(), "Popa");
        assertEquals(dv.getBrand(), "Audi");
        assertEquals(dv.getService_condition(), "Audi");

    }

    @Test
    @DisplayName("Retrieve all vehicle lines")
    public void getVehicleLineTest(){
        //arrange
        when(mainRepository.getVehicleLines()).thenReturn(
                Arrays.asList(new VehicleLine(1, 2, "BMW", "poor", "Focsani", "Bucuresti", "peoples", 120))
        );

        //act
        List<VehicleLine> result = mainService.getVehicleLine();

        //assert
        VehicleLine vl = result.get(0);
        assertEquals(result.size(), 1);
        assertEquals(vl.getIdDriver(), 2);
        assertEquals(vl.getBrand(), "BMW");
        assertEquals(vl.getService_condition(), "poor");
        assertEquals(vl.getDeparture(), "Focsani");
        assertEquals(vl.getDestination(), "Bucuresti");
        assertEquals(vl.getType(), "peoples");
        assertEquals(vl.getDuration(), 120);

    }
    @Test
    @DisplayName("Retrieve all lines price")
    public void getLinePriceTest(){
        //arrange
        when(mainRepository.getLinesPrice()).thenReturn(
                Arrays.asList(new LinePrice(1, "Focsani", "Bucuresti", 120, 29.0, "Euro"))
        );

        //act
        List<LinePrice> result = mainService.getLinePrice();

        //assert
        LinePrice lp = result.get(0);
        assertEquals(result.size(), 1);
        assertEquals(lp.getDeparture(), "Focsani");
        assertEquals(lp.getDestination(), "Bucuresti");
        assertEquals(lp.getDuration(), 120);
        assertEquals(lp.getPrice(), 29.0);
        assertEquals(lp.getCurrency(), "Euro");

    }
}
