package com.example.mastersofpuppets.service;


import com.example.mastersofpuppets.models.Masters;
import com.example.mastersofpuppets.models.Puppets;
import com.example.mastersofpuppets.repository.MastersRepo;
import com.example.mastersofpuppets.repository.PuppetsRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.Collections;
import java.util.List;

@SpringBootTest
@Transactional
public class PuppetsServiceTest {
    @Autowired
    MastersRepo mastersRepo;
    @Autowired
    PuppetsRepo puppetsRepo;

    @BeforeEach
    public void setup(){
        puppetsRepo.deleteAll();
        mastersRepo.deleteAll();
    }
    @Test
    public void addPuppet(){
        //given
        Puppets puppets = getPuppet();
        //when
        puppetsRepo.save(puppets);
        //then
        List<Puppets> list = puppetsRepo.findAll();
        assertThat(list.size()).isEqualTo(1);
    }
    @Test
    public void showAllPuppets(){
        //given
        //when
        //then


    }
    @Test
    public void showPuppetsByNameOfPuppet(){
        //given
        //when
        //then

    }
    @Test
    public void findAllPuppetsByMasterName(){
        //given
        //when
        //then

    }

    private Masters getMaster(){
        return new Masters("Masters1","Des1", Collections.emptyList());
    }

    private Puppets getPuppet(){
        return new Puppets("Puppet1", "Desc1", Collections.emptyList());
    }


}
