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

    public Long getUserId() {
        return Long.valueOf(((AuthDetails)getAuthentication().getPrincipal()).getId());
    }

}
