package com.example.mastersofpuppets.service;

import com.example.mastersofpuppets.Exception.MastersNotExist;
import com.example.mastersofpuppets.Exception.NameAlreadyExist;
import com.example.mastersofpuppets.models.Masters;
import com.example.mastersofpuppets.models.Puppets;
import com.example.mastersofpuppets.modelsDTO.Mapper;
import com.example.mastersofpuppets.modelsDTO.MastersDTO;
import com.example.mastersofpuppets.modelsDTO.PuppetsDTO;
import com.example.mastersofpuppets.repository.MastersRepo;
import com.example.mastersofpuppets.repository.PuppetsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@Transactional
public class PuppetsService {
        private final Mapper mapper;
        private final PuppetsRepo puppetsRepo;
        private final MastersRepo mastersRepo;


        @Autowired
        public PuppetsService(Mapper mapper, PuppetsRepo puppetsRepo,
                              MastersRepo mastersRepo) {
                this.mapper = mapper;
                this.puppetsRepo = puppetsRepo;
                this.mastersRepo = mastersRepo;
        }
        public List<PuppetsDTO> puppetsList(){
                return puppetsRepo
                        .findAll()
                        .stream()
                        .map(mapper::puppetsToDTO)
                        .collect(toList());
        }

        public PuppetsDTO addPuppets (PuppetsDTO puppetsDTO){
                Puppets puppets = mapper.puppetsDTOToPuppets(puppetsDTO);
                Puppets save = puppetsRepo.save(puppets);
                return mapper.puppetsToDTO(save);
        }

        public List<MastersDTO> getMastersDTO( String puppetsName) {
                return puppetsList()
                        .stream()
                        .filter(f -> f.getNameOfPuppetDTO().equals(puppetsName))
                        .findFirst()
                        .map(PuppetsDTO::getMastersDTOList)
                        .get();
                }

        public PuppetsDTO addPuppetsToMasters(PuppetsDTO puppetsDTO, String namesOfMaster) {

                if (mastersRepo.findByNameOfMaster(namesOfMaster).isEmpty()){
                        throw new MastersNotExist();
                }
                Masters masters = (Masters) mastersRepo.findByNameOfMaster(namesOfMaster).orElseThrow();
                if (masters.getShowPuppets().stream()
                        .anyMatch(puppets -> puppets.getNameOfPuppet()
                                .equalsIgnoreCase(puppetsDTO.getNameOfPuppetDTO()))){
                        throw new NameAlreadyExist();
                }

                Puppets save = puppetsRepo.save(mapper.puppetsDTOToPuppets(puppetsDTO));
                masters.getShowPuppets().add(save);
                mastersRepo.save(masters);
                return mapper.puppetsToDTO(save);
        }
}





