package com.sergiolopezmi.apitiempo.repositories;

import com.sergiolopezmi.apitiempo.entities.Weather;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherRepository extends JpaRepository<Weather, Integer> {

}
