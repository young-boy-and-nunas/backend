package com.youngboyandnunas.backend.global.security.service;

import com.youngboyandnunas.backend.global.security.auth.AuthDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationFacade {

    private Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public String getUserId() {
        return ((AuthDetails)getAuthentication().getPrincipal()).getId();
    }

}
