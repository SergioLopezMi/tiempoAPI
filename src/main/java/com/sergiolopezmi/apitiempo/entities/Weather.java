package com.sergiolopezmi.apitiempo.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

/**
 * <h1>Clase Weather</h1>
 *
 * <p>Contiene el regístro del clima en un tiempo determinado.</p>
 * <p>La temperatura se encuentra en <b>grados Celsius</b></p>
 *</br>
 *<p>
 *  @author Sergio Lopez
 *  @version 1.0
 * </p>
 */

@Entity
@Table(name = "weather")
public class Weather implements Serializable {

    private static final long serialVersionUID = 5985371964066351380L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "hour")
    private LocalTime hour;

    @Column(name = "temperature")
    private float temperature;

    @Column(name = "humidity")
    private float humidity;

    public Weather(){ }

    public void setId(Integer id){
        this.id = id;
    }

    public Integer getId(){
        return this.id;
    }

    public void setDate(LocalDate date){
        this.date = date;
    }

    public LocalDate getDate(){
        return this.date;
    }

    public void setHour(LocalTime hour){
        this.hour = hour;
    }

    public LocalTime getHour(){
        return this.hour;
    }

    public void setTemperature(float temperature){
        this.temperature = temperature;
    }

    public float getTemperature(){
        return this.temperature;
    }

    public void setHumidity(float humidity){
        this.humidity = humidity;
    }

    public float getHumidity(){
        return this.humidity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Weather weather = (Weather) o;
        return Float.compare(weather.temperature, temperature) == 0 &&
                Float.compare(weather.humidity, humidity) == 0 &&
                Objects.equals(id, weather.id) &&
                Objects.equals(date, weather.date) &&
                Objects.equals(hour, weather.hour);
    }
}
