package com.example.mastersofpuppets.modelsDTO;


import com.example.mastersofpuppets.models.Masters;
import com.example.mastersofpuppets.models.Puppets;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class Mapper {
    
    public MastersDTO mastersToDTO(Masters masters){
        String nameOfMaster = masters.getNameOfMaster();
        String descriptionOfMaster = masters.getDescriptionOfMaster();
        List<PuppetsDTO> puppetsDTOList = masters.getShowPuppets()
                .stream()
                .map(this::puppetsToDTO)
                .collect(Collectors.toList());
        return new MastersDTO(nameOfMaster, descriptionOfMaster,puppetsDTOList);
    }

    public PuppetsDTO puppetsToDTO(Puppets puppets) {
        String nameOfPuppets = puppets.getNameOfPuppet();
        List<MastersDTO> mastersDTOList = puppets.getShowMasters()
                .stream()
                .map(this::mastersToDTO)
                .collect(Collectors.toList());
        return new PuppetsDTO(nameOfPuppets,mastersDTOList);
    }
    public Masters mastersDTOToMasters (MastersDTO mastersDTO){
        return new Masters(
                mastersDTO.getNameOfMaster(), 
                mastersDTO.getDescriptionOfMaster(),
                mastersDTO.getPuppetsDTOList()
                        .stream()
                        .map(this::puppetsDTOToPuppets)
                        .collect(Collectors.toList()));

}
    public Puppets puppetsDTOToPuppets(PuppetsDTO puppetsDTO) {
        return new Puppets(
                puppetsDTO.getNameOfPuppetDTO(),
                puppetsDTO.getDescriptionOfPuppetDTO(),
                puppetsDTO.getMastersDTOList()
                        .stream()
                        .map(this::mastersDTOToMasters)
                        .collect(Collectors.toList()));
    }
}
