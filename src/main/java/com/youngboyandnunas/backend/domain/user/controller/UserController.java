package com.youngboyandnunas.backend.domain.user.controller;

import com.youngboyandnunas.backend.domain.user.dto.UserResponse;
import com.youngboyandnunas.backend.domain.user.service.UserService;
import com.youngboyandnunas.backend.global.security.service.AuthenticationFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final AuthenticationFacade authenticationFacade;
    private final UserService userService;

    @GetMapping("/user")
    public UserResponse getUser() {
        return userService.getUser(authenticationFacade.getUserId());
    }

    @DeleteMapping("/user")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void withThrowUser() {
        userService.withThrowUser(authenticationFacade.getUserId());
    }

}
