package com.youngboyandnunas.backend.global.security.auth;

import com.youngboyandnunas.backend.domain.user.dao.UserRepository;
import com.youngboyandnunas.backend.global.exception.ErrorCode;
import com.youngboyandnunas.backend.global.exception.GlobalException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (userRepository.existsById(Long.valueOf(username))) {
            return new AuthDetails(username);
        } else {
            throw new GlobalException(ErrorCode.UNAUTHORIZED_ERROR);
        }
    }

}