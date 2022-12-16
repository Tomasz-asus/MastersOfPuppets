package com.example.mastersofpuppets.controllers;

import com.example.mastersofpuppets.Exception.MastersNotExist;
import com.example.mastersofpuppets.Exception.NameAlreadyExist;
import com.example.mastersofpuppets.modelsDTO.MastersDTO;
import com.example.mastersofpuppets.modelsDTO.PuppetsDTO;
import com.example.mastersofpuppets.service.MastersService;
import com.example.mastersofpuppets.service.PuppetsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//todo MastersController

@Controller
public class MastersController {

    private final MastersService mastersService;

    private final PuppetsService puppetsService;


    public MastersController(MastersService mastersService, PuppetsService puppetsService) {
        this.mastersService = mastersService;
        this.puppetsService = puppetsService;
    }
    @PostMapping("/masters")
    @ResponseBody
    public MastersDTO createMaster(@RequestBody MastersDTO mastersDTO){

        return mastersService.addMasters(mastersDTO);
    }

    @GetMapping("/masters")
    @ResponseBody
    public List<MastersDTO> getMasters(){
        return mastersService.mastersList();
    }

    @PostMapping("/masters/{namesOfMaster}/puppets")
    @ResponseBody
    public PuppetsDTO createPuppetsToMasters(@RequestBody PuppetsDTO puppetsDTO,
                                             @PathVariable String namesOfMaster)
    throws NameAlreadyExist, MastersNotExist {
        return puppetsService.addPuppetsToMasters(puppetsDTO, namesOfMaster);
    }

    @GetMapping("/masters/{namesOfMaster}/puppets")
    @ResponseBody
    public List<PuppetsDTO> getPuppetsToMaster(@PathVariable String namesOfMaster){
        return mastersService.getPuppetsDTO(namesOfMaster);
    }
}
