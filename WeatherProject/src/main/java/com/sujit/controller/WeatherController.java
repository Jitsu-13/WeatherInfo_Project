package com.sujit.controller;


import javax.validation.Valid;

import com.sujit.model.SearchDTO;
import com.sujit.model.Weather;
import com.sujit.services.LocaltionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;




@RestController
@RequestMapping("/weathers")
public class WeatherController {
    @Autowired
    private LocaltionServices lServices;

    @PostMapping("/data")
    public ResponseEntity<Weather> getWeatherHandler(@Valid @RequestBody SearchDTO searchDTO){
        Weather weather = lServices.getWeather(searchDTO);
        return  new ResponseEntity<Weather>(weather,HttpStatus.ACCEPTED);

    }


}
