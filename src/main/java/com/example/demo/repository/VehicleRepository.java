package com.example.demo.repository;

import com.example.demo.model.Vehicle;
import com.example.demo.querys.Querys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class VehicleRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Vehicle> getVehicles() {
        List<Vehicle> vehicles = jdbcTemplate.query(Querys.GET_VEHICLES_SQL, (resultSet, i) ->  new Vehicle(
                resultSet.getInt("id"),
                resultSet.getInt("idDriver"),
                resultSet.getInt("idLine"),
                resultSet.getString("brand"),
                resultSet.getInt("year"),
                resultSet.getString("service_condition")


        ));

        jdbcTemplate.update(Querys.ADD_ACTION, "Retrieving vehicles from database", LocalDate.now());
        return vehicles;
    }

    public List<Vehicle> addVehicle(Vehicle p) {
        jdbcTemplate.update(Querys.ADD_VEHICLE, p.getIdDriver(), p.getIdLine(), p.getBrand(), p.getYear(), p.getServiceCondition());
        return getVehicles();
    }

    public List<Vehicle> deleteVehicleById(int id) {
        jdbcTemplate.update(Querys.DELETE_VEHICLE,id);
        return getVehicles();
    }
}
