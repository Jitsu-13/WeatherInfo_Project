package com.sujit.Repository;


import com.sujit.Model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface LocationRepository extends JpaRepository<Location,Integer> {


}
