package com.sujit.Model;



import javax.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;


@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SearchDTO {


    private Integer pincode;
    @Past(message = "Entered date should be in past")
    private LocalDate dateStamp;



    

}
