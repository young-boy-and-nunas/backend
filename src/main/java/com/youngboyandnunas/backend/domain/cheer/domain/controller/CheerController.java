package com.youngboyandnunas.backend.domain.cheer.domain.controller;

import com.youngboyandnunas.backend.domain.cheer.domain.dto.CheerDTO;
import com.youngboyandnunas.backend.domain.cheer.domain.service.CheerService;
import com.youngboyandnunas.backend.global.security.service.AuthenticationFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cheer")
public class CheerController {

    private final CheerService cheerService;
    private final AuthenticationFacade authenticationFacade;

    @Autowired
    public CheerController(CheerService cheerService, AuthenticationFacade authenticationFacade) {
        this.cheerService = cheerService;
        this.authenticationFacade = authenticationFacade;
    }

    @PostMapping("/cheer")
    public void makeCheer(CheerDTO cheerDTO){
        cheerDTO.setUserId(authenticationFacade.getUserId());
        cheerService.insertCheer(cheerDTO);
    }

    @GetMapping("/select/20")
    public void selectLimit20Cheer(){

        Long userId = authenticationFacade.getUserId();
        cheerService.selectLimit20Cheer(userId);

    }

    @PutMapping("/update-check")
    public void updateCheck(Long cheerSeq){
        cheerService.updateCheck(cheerSeq);
    }

}
