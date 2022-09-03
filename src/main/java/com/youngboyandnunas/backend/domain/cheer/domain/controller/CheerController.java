package com.youngboyandnunas.backend.domain.cheer.domain.controller;

import com.youngboyandnunas.backend.domain.cheer.domain.dto.CheerDTO;
import com.youngboyandnunas.backend.domain.cheer.domain.service.CheerService;
import com.youngboyandnunas.backend.global.security.service.AuthenticationFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/cheer")
public class CheerController {

    private final CheerService cheerService;
    private final AuthenticationFacade authenticationFacade;

    @Autowired
    public CheerController(CheerService cheerService, AuthenticationFacade authenticationFacade) {
        this.cheerService = cheerService;
        this.authenticationFacade = authenticationFacade;
    }

    //TODO : return reseponse
    @PostMapping("/")
    public void makeCheer(CheerDTO cheerDTO){

        cheerDTO.setUserId(authenticationFacade.getUserId());
        cheerService.insertCheer(cheerDTO);
    }
}
