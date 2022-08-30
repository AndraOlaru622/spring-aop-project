package com.example.demo.repository;

import com.example.demo.model.Line;
import com.example.demo.querys.Querys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class LineRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Line> getLines() {
        List<Line> lines = jdbcTemplate.query(Querys.GET_LINES_SQL, (resultSet, i) ->  new Line(
                resultSet.getInt("id"),
                resultSet.getString("departure"),
                resultSet.getString("destination"),
                resultSet.getString("type"),
                resultSet.getInt("duration")


        ));

        jdbcTemplate.update(Querys.ADD_ACTION, "Retrieving lines from database", LocalDate.now());
        return lines;
    }

    public List<Line> addLine(Line p) {
        jdbcTemplate.update(Querys.ADD_LINE, p.getDeparture(), p.getDestination(), p.getType(), p.getDuration());
        return getLines();
    }

    public List<Line> deleteLineById(int id) {
        jdbcTemplate.update(Querys.DELETE_LINE,id);
        return getLines();
    }
}
