package com.example.mastersofpuppets.controllers;

import com.example.mastersofpuppets.modelsDTO.PuppetsDTO;
import com.example.mastersofpuppets.service.MastersService;
import com.example.mastersofpuppets.service.PuppetsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//todo PuppetsController
@Controller
public class PuppetsController {


    private final MastersService mastersService;

    private final PuppetsService puppetsService;

    public PuppetsController(MastersService mastersService, PuppetsService puppetsService) {
        this.mastersService = mastersService;
        this.puppetsService = puppetsService;
    }

    @PostMapping("/puppets")
    @ResponseBody
    public PuppetsDTO createPuppet(@RequestBody PuppetsDTO puppetsDTO) {
        return puppetsService.addPuppets(puppetsDTO);
    }

    @GetMapping("/puppets")
    @ResponseBody

    public List<PuppetsDTO> getPuppets() {
        return puppetsService.puppetsList();
    }

}
