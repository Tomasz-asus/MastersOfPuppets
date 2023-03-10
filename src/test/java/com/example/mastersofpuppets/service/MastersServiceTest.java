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

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class MastersServiceTest {
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
    public void addMaster(){
        //given
        Masters masters = getMaster();
        //when
        mastersRepo.save(masters);
        //then
        List<Masters> list = mastersRepo.findAll();
        assertThat(list.size()).isEqualTo(1);
    }
    @Test
    public void showAllMasters(){
        //given
        //when
        //then

    }
    @Test
    public void showMastersByNameOfMasters(){
        //given
        //when
        //then

    }
    @Test
    public void findAllMastersByPuppetName(){
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
