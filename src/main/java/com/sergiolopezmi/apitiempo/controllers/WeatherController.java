package com.sergiolopezmi.apitiempo.controllers;

import com.sergiolopezmi.apitiempo.entities.Weather;
import com.sergiolopezmi.apitiempo.repositories.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/tiempo")
public class WeatherController {
    @Autowired
    WeatherRepository weatherRepository;

    @GetMapping
    public List<Weather> findAll() {

        return weatherRepository.findAll();
    }

    @GetMapping("/buscar")
    public ResponseEntity findByDate(@RequestBody Map<String, String> dateString) {
        if (dateString.containsKey("date")) {
            LocalDate dateFind = LocalDate.parse(dateString.get("date"));
            return ResponseEntity.ok().body(weatherRepository.findByDate(dateFind));
        }
        return ResponseEntity.badRequest().body("Fecha no informada");
    }

    @PostMapping
    public ResponseEntity save(@RequestBody Map<String, Float> weatherIn) {

        if (weatherIn.containsKey("temperature") && weatherIn.containsKey(("humidity"))) {
            Weather newWeather = new Weather();

            newWeather.setTemperature(weatherIn.get("temperature"));
            newWeather.setHumidity(weatherIn.get("humidity"));
            newWeather.setDate(LocalDate.now());
            newWeather.setHour(LocalTime.now());

            return ResponseEntity.status(HttpStatus.OK).body(weatherRepository.save(newWeather));
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Humedad o temperatura no están informados correctamente");

    }
}
