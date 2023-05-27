package com.sujit.repository;


import com.sujit.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface LocationRepository extends JpaRepository<Location,Integer> {


}
