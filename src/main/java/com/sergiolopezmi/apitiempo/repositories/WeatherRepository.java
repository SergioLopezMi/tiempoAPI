package com.sergiolopezmi.apitiempo.repositories;

import com.sergiolopezmi.apitiempo.entities.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface WeatherRepository extends JpaRepository<Weather, Integer> {
    @Query("select w from Weather w where w.date = :date")
    List<Weather> findByDate(@Param("date") LocalDate date);
}
