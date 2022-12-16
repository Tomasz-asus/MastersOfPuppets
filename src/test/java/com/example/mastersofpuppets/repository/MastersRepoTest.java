package com.example.mastersofpuppets.repository;

import com.example.mastersofpuppets.models.Masters;
import com.example.mastersofpuppets.models.Puppets;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class MastersRepoTest {
    @Autowired
    MastersRepo mastersRepo;
    @Autowired
    PuppetsRepo puppetsRepo;


    @Test
    public void addMasters(){
        //given
        Masters masters = new Masters("dd","de", Collections.emptyList());
        //when
        mastersRepo.save(masters);
        //then
        List<Masters> list = mastersRepo.findAll();
        assertThat(list.size()).isEqualTo(1);
    }

    @Test
    public void addMastersToPuppets(){
        //given
        Puppets puppets = new Puppets("Pappes1","desc", Collections.emptyList());
        Puppets puppets1 = puppetsRepo.save(puppets);
        Masters masters = new Masters("dd", "desc",Collections.emptyList());
        mastersRepo.save(masters);
        List<Masters> mastersList = mastersRepo.findAll();
        //when
        puppets1.setShowMasters(mastersList);

        //then
        assertThat(masters.equals(puppets1.getShowMasters()));


    }

}
