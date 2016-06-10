package com.mmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.mmt.model.Airport;

@Service
@Configuration
public class DBService {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Value("${allAirports}")
    private String allAirports;
    
    @Value("${allAirportsOfCountry}")
    private String allAirportsOfCountry;
    

    public List<Airport> getAllAirports(int limit, int offset) {
        List<Airport> airports = jdbcTemplate.query(allAirports, new Object[] { limit, offset }, new BeanPropertyRowMapper<Airport>(Airport.class));
        return airports;
    }
    
    public List<Airport> getAllAirportsOfCountry(String country, int limit, int offset) {
        List<Airport> airports = jdbcTemplate.query(allAirportsOfCountry, new Object[] { country, limit, offset }, new BeanPropertyRowMapper<Airport>(Airport.class));
        return airports;
    }

}
