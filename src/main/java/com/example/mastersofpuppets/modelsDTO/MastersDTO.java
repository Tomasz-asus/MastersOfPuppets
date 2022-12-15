package com.example.mastersofpuppets.modelsDTO;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.List;

public class MastersDTO {

    private String nameOfMaster;
    private String descriptionOfMaster;
    private List<PuppetsDTO>puppetsDTOList;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public MastersDTO(String nameOfMaster,
                      String descriptionOfMaster,
                      List<PuppetsDTO> puppetsDTOList) {
        this.nameOfMaster = nameOfMaster;
        this.descriptionOfMaster = descriptionOfMaster;
        this.puppetsDTOList = puppetsDTOList;
    }


    public String getNameOfMaster() {
        return nameOfMaster;
    }

    public String getDescriptionOfMaster() {
        return descriptionOfMaster;
    }

    public List<PuppetsDTO> getPuppetsDTOList() {
        return puppetsDTOList;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
