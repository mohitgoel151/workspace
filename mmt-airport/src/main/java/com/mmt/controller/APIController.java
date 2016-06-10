package com.mmt.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mmt.model.Airport;
import com.mmt.service.DBService;

@RestController
@EnableAutoConfiguration
public class APIController {

    @Autowired
    private DBService dBService;

    @Value("${DEFAULT_PAGE_SIZE}")
    private int pageSize;
    
 
    @RequestMapping("/")
    String home() {
        return "Hello Mohit!" + (new Date()).toString();
    }
    
    @RequestMapping("/airports")
    public List<Airport> getAllAirports(@RequestParam(name="page", defaultValue="1")  int pageNo) {

        return dBService.getAllAirports(pageSize, (pageNo - 1) * pageSize);
    }
    
    @RequestMapping("/airports/countries/{countryName}")
    public List<Airport> getAllAirportsOfCountry(@PathVariable("countryName") String  countryName, 
                                                 @RequestParam(name="page", defaultValue="1")  int pageNo) {

        return dBService.getAllAirportsOfCountry(countryName, pageSize, (pageNo - 1) * pageSize);
    }


}
