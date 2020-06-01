package com.sergiolopezmi.apitiempo.repositories;

import com.sergiolopezmi.apitiempo.entities.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface WeatherRepository extends JpaRepository<Weather, Integer> {

    @Query("SELECT W FROM Weather W WHERE W.date = :date")
    List<Weather> findByDate(@Param("date") LocalDate date);

    @Query("SELECT W FROM Weather W WHERE W.date >= :date AND W.date <= :date2")
    List<Weather> findByDateRange(@Param("date") LocalDate date, @Param("date2") LocalDate date2);
}
