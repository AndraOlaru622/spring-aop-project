package com.example.demo.repository;

import com.example.demo.model.DriverLocation;
import com.example.demo.model.DriverVehicle;
import com.example.demo.model.VehicleLine;
import com.example.demo.model.LinePrice;
import com.example.demo.querys.Querys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class MainRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<DriverLocation> getDriverLocations() {
        List<DriverLocation> driver_locations = jdbcTemplate.query(Querys.DRIVERS_LOCATION, (resultSet, i) ->  new DriverLocation(
                resultSet.getInt("id"),
                resultSet.getString("first_name"),
                resultSet.getString("last_name"),
                resultSet.getString("city"),
                resultSet.getString("country")

        ));

        jdbcTemplate.update(Querys.ADD_ACTION, "Retrieving driver's locations from database", LocalDate.now());
        return driver_locations;
    }

    public List<DriverVehicle> getDriverVehicles() {
        List<DriverVehicle> driver_vehicles = jdbcTemplate.query(Querys.DRIVERS_VEHICLE, (resultSet, i) ->  new DriverVehicle(
                resultSet.getInt("id"),
                resultSet.getString("first_name"),
                resultSet.getString("last_name"),
                resultSet.getString("brand"),
                resultSet.getString("service_condition")

        ));

        jdbcTemplate.update(Querys.ADD_ACTION, "Retrieving driver's vehicles from database", LocalDate.now());
        return driver_vehicles;
    }

    public List<VehicleLine> getVehicleLines() {
        List<VehicleLine> vehicle_lines = jdbcTemplate.query(Querys.VEHICLES_LINE, (resultSet, i) ->  new VehicleLine(
                resultSet.getInt("id"),
                resultSet.getInt("idDriver"),
                resultSet.getString("brand"),
                resultSet.getString("service_condition"),
                resultSet.getString("departure"),
                resultSet.getString("destination"),
                resultSet.getString("type"),
                resultSet.getInt("duration")

        ));

        jdbcTemplate.update(Querys.ADD_ACTION, "Retrieving vehicle's line from database", LocalDate.now());
        return vehicle_lines;
    }

    public List<LinePrice> getLinesPrice() {
        List<LinePrice> lines_price = jdbcTemplate.query(Querys.LINES_PRICE, (resultSet, i) ->  new LinePrice(
                resultSet.getInt("id"),
                resultSet.getString("departure"),
                resultSet.getString("destination"),
                resultSet.getInt("duration"),
                resultSet.getDouble("price"),
                resultSet.getString("currency")

        ));

        jdbcTemplate.update(Querys.ADD_ACTION, "Retrieving line's price from database", LocalDate.now());
        return lines_price;
    }
}
