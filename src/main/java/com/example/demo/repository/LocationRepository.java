package com.example.demo.repository;

import com.example.demo.model.Location;
import com.example.demo.querys.Querys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class LocationRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Location> getLocations() {
        List<Location> locations = jdbcTemplate.query(Querys.GET_LOCATIONS_SQL, (resultSet, i) ->  new Location(
                resultSet.getInt("id"),
                resultSet.getString("city"),
                resultSet.getString("country")

        ));

        jdbcTemplate.update(Querys.ADD_ACTION, "Retrieving locations from database", LocalDate.now());
        return locations;
    }

    public List<Location> addLocation(Location p) {
        jdbcTemplate.update(Querys.ADD_LOCATION, p.getCity(), p.getCountry());
        return getLocations();
    }

    public List<Location> deleteLocationById(int id) {
        jdbcTemplate.update(Querys.DELETE_LOCATION,id);
        return getLocations();
    }
}
