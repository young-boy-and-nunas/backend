package com.youngboyandnunas.backend.domain.cheer.domain.controller;

import com.youngboyandnunas.backend.domain.cheer.domain.dto.CheerDTO;
import com.youngboyandnunas.backend.domain.cheer.domain.service.CheerService;
import com.youngboyandnunas.backend.global.security.service.AuthenticationFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.Charset;
import java.util.List;

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
    public ResponseEntity<List<CheerDTO>> selectLimit20Cheer(){

        Long userId = authenticationFacade.getUserId();
        List<CheerDTO> cheerDTOS = cheerService.selectLimit20Cheer(userId);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        return new ResponseEntity<>(cheerDTOS, headers, HttpStatus.OK);

    }

    @PutMapping("/update-check")
    public void updateCheck(Long cheerSeq){

        cheerService.updateCheck(cheerSeq);

    }

}
