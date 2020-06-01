package com.sergiolopezmi.apitiempo.controllers;

import com.sergiolopezmi.apitiempo.entities.Weather;
import com.sergiolopezmi.apitiempo.repositories.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/tiempo")
public class WeatherController {
    @Autowired
    WeatherRepository weatherRepository;

    @GetMapping
    public List findAll(){
        return weatherRepository.findAll();
    }

    @PostMapping
    public Weather save(@RequestBody Map<String, Float> weatherIn){
        if(weatherIn != null){

            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            Weather newWeather = new Weather();

            newWeather.setTemperature(weatherIn.get("temperature"));
            newWeather.setHumidity(weatherIn.get("humidity"));
            newWeather.setDate(LocalDate.now());
            newWeather.setHour(LocalTime.now());
            return weatherRepository.save(newWeather);
            }
        return null;

    }
}
