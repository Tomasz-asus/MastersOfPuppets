package com.example.mastersofpuppets.repository;

import com.example.mastersofpuppets.models.Masters;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface MastersRepo extends JpaRepository<Masters, Long> {

    Optional<Object> findByNameOfMaster(String namesOfMaster);
}
