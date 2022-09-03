package com.youngboyandnunas.backend.domain.user.controller;

import com.youngboyandnunas.backend.domain.user.service.TokenCheckService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class CheckController {

    private final TokenCheckService tokenCheckService;

    @RequestMapping("/sign-up")
    public String signUp(@RequestParam("token") String token) {
        if(tokenCheckService.signUp(token))
            return "Success.html";
        return "Fail.html";
    }

}
