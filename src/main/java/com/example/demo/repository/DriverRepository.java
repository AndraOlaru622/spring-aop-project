package com.example.demo.repository;

import com.example.demo.model.Driver;
import com.example.demo.querys.Querys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class DriverRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Driver> getDrivers() {
      List<Driver> drivers = jdbcTemplate.query(Querys.GET_DRIVERS_SQL, (resultSet, i) ->  new Driver(
                    resultSet.getInt("id"),
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name"),
                    resultSet.getInt("age"),
                    resultSet.getInt("year_employment"),
                    resultSet.getDouble("salary"),
                    resultSet.getInt("idLocation")


            ));

        jdbcTemplate.update(Querys.ADD_ACTION, "Retrieving drivers from database", LocalDate.now());
        return drivers;
    }

    public List<Driver> addDriver(Driver p) {
        jdbcTemplate.update(Querys.ADD_DRIVER, p.getFirst_name(), p.getLast_name(), p.getAge(), p.getYear_employment(), p.getSalary(), p.getIdLocation());
        jdbcTemplate.update(Querys.ADD_ACTION, "Adding driver to database", LocalDate.now());
        return getDrivers();
    }

    public List<Driver> getDriverById(int id) {
        return getDrivers().stream()
                .filter(driver -> driver.getId() == id)
                .collect(Collectors.toList());
    }

    public List<Driver> updateDriver(Driver p, int id) {
        jdbcTemplate.update(Querys.UPDATE_DRIVER, p.getFirst_name(), p.getLast_name(), p.getAge(), p.getYear_employment(), p.getSalary(), p.getIdLocation(), id);
        jdbcTemplate.update(Querys.ADD_ACTION, "Updating driver to database", LocalDate.now());
        return getDrivers();
    }

    public List<Driver> deleteDriverById(int id) {
        jdbcTemplate.update(Querys.DELETE_DRIVER,id);
        return getDrivers();
    }

}
