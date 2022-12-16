package com.example.mastersofpuppets.repository;


import com.example.mastersofpuppets.models.Masters;
import com.example.mastersofpuppets.models.Puppets;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.Collections;
import java.util.List;

@SpringBootTest
@Transactional
class PuppetsRepoTest {
    @Autowired
    PuppetsRepo puppetsRepo;
    @Autowired
    MastersRepo mastersRepo;
    @Test
    public void addPuppets(){
        //given
        Puppets puppets = new Puppets("dd","de", Collections.emptyList());
        //when
        puppetsRepo.save(puppets);
        //then
        List<Puppets> list = puppetsRepo.findAll();
        assertThat(list.size()).isEqualTo(1);
    }

    @Test
    public void addPuppetsToMasters(){
        //given
        Masters masters = new Masters("Masters1","des", Collections.emptyList());
        Masters masters1 = mastersRepo.save(masters);
        Puppets puppets = new Puppets("dd", "de",Collections.emptyList());
        puppetsRepo.save(puppets);
        List<Puppets> puppetsList = puppetsRepo.findAll();
        //when
        masters1.setShowPuppets(puppetsList);
        //then
        assertThat(puppets.equals(masters1.getShowPuppets()));
    }
}
