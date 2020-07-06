package com.sergiolopezmi.apitiempo.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

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

@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode

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
}
