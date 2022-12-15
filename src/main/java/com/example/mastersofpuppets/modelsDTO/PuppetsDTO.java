package com.example.mastersofpuppets.modelsDTO;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.List;

public class PuppetsDTO {
    private String nameOfPuppetDTO;
    private String descriptionOfPuppetDTO;

    private List<MastersDTO>mastersDTOList;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public PuppetsDTO(String nameOfPuppetDTO, String descriptionOfPuppetDTO, List<MastersDTO> mastersDTOList) {
        this.nameOfPuppetDTO = nameOfPuppetDTO;
        this.descriptionOfPuppetDTO = descriptionOfPuppetDTO;
        this.mastersDTOList = mastersDTOList;
    }

    public PuppetsDTO(String nameOfPuppets, List<MastersDTO> mastersDTOList) {
    }

    public List<MastersDTO> getMastersDTOList() {
        return mastersDTOList;
    }

    public String getNameOfPuppetDTO() {
        return nameOfPuppetDTO;
    }

    public String getDescriptionOfPuppetDTO() {
        return descriptionOfPuppetDTO;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
