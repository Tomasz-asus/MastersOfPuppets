package com.example.mastersofpuppets.repository;


import com.example.mastersofpuppets.models.Puppets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PuppetsRepo extends JpaRepository <Puppets, Long> {

}
