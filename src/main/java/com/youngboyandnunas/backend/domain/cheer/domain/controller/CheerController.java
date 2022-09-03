package com.youngboyandnunas.backend.domain.cheer.domain.controller;

import com.youngboyandnunas.backend.domain.cheer.domain.dto.CheerDTO;
import com.youngboyandnunas.backend.domain.cheer.domain.service.CheerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/cheer")
public class CheerController {

    private final CheerService cheerService;

    @Autowired
    public CheerController(CheerService cheerService) {
        this.cheerService = cheerService;
    }

    //TODO : return reseponse
    @PostMapping("/")
    public void makeCheer(CheerDTO cheerDTO){

        cheerService.insertCheer(cheerDTO);
    }
}
