package com.sujit.model;




import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Weather {

    @Id
    private Integer pin;
    private String cloud;
    private BigDecimal temperature;
    private BigDecimal temperature_min;

    private BigDecimal temperature_max;

    private Integer pressure;

    private Integer humidity;

    private BigDecimal windSpeed;

    private Integer WindDirection;

    private String country;




}
