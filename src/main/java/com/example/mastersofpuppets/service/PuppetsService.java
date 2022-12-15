package com.example.mastersofpuppets.service;

import com.example.mastersofpuppets.models.Puppets;
import com.example.mastersofpuppets.modelsDTO.Mapper;
import com.example.mastersofpuppets.modelsDTO.MastersDTO;
import com.example.mastersofpuppets.modelsDTO.PuppetsDTO;
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

        @Autowired
        public PuppetsService(Mapper mapper, PuppetsRepo puppetsRepo) {
                this.mapper = mapper;
                this.puppetsRepo = puppetsRepo;
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
        }





