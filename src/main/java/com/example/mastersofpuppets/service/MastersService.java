package com.example.mastersofpuppets.service;


import com.example.mastersofpuppets.models.Masters;
import com.example.mastersofpuppets.modelsDTO.Mapper;
import com.example.mastersofpuppets.modelsDTO.MastersDTO;
import com.example.mastersofpuppets.modelsDTO.PuppetsDTO;
import com.example.mastersofpuppets.repository.MastersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@Transactional
public class MastersService {
        private final Mapper mapper;
        private final MastersRepo mastersRepo;


    @Autowired
        public MastersService(Mapper mapper, MastersRepo mastersRepo) {
        this.mapper = mapper;
        this.mastersRepo = mastersRepo;
    }

    public List<MastersDTO> mastersList(){
        return mastersRepo
                .findAll()
                .stream()
                .map(mapper::mastersToDTO)
                .collect(toList());
    }

    public MastersDTO addMasters (MastersDTO mastersDTO){
        Masters masters = mapper.mastersDTOToMasters(mastersDTO);
        Masters save = mastersRepo.save(masters);
        return mapper.mastersToDTO(save);
    }

    public List<PuppetsDTO> getPuppetsDTO(String mastersName){
        return mastersList()
                .stream()
                .filter(f->f.getNameOfMaster().equals(mastersName))
                .findFirst()
                .map(MastersDTO::getPuppetsDTOList)
                .get();
    }
}
