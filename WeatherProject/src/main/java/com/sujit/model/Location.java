package com.sujit.model;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;



@Entity
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Location {

    @Id
    private Integer pincode;
    private BigDecimal lattitude;
    private BigDecimal longitude;
    private String detail;
    @OneToOne(cascade = CascadeType.ALL)
    private Weather WeatherPincode;

    @Past
    private LocalDate dateStamp;

    
    


}
