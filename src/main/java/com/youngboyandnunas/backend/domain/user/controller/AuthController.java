package com.youngboyandnunas.backend.domain.user.controller;

import com.youngboyandnunas.backend.domain.user.dto.SignUpRequest;
import com.youngboyandnunas.backend.domain.user.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/sign-up/email")
    @ResponseStatus(HttpStatus.CREATED)
    private void signUp(@Valid @RequestBody SignUpRequest request) {
        authService.signUp(request);
    }

}
