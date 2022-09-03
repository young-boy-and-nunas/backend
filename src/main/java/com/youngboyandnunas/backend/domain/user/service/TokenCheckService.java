package com.youngboyandnunas.backend.domain.user.service;

import com.youngboyandnunas.backend.domain.user.dao.SignUpCertifyRepository;
import com.youngboyandnunas.backend.domain.user.dao.UserRepository;
import com.youngboyandnunas.backend.domain.user.domain.SignUpCertify;
import com.youngboyandnunas.backend.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TokenCheckService {

    private final SignUpCertifyRepository signUpCertifyRepository;
    private final UserRepository userRepository;

    public boolean signUp(String token) {
        final Optional<SignUpCertify> optionalSignUpCertify = signUpCertifyRepository.findById(UUID.fromString(token));
        if(optionalSignUpCertify.isEmpty())
            return false;
        final SignUpCertify signUpCertify = optionalSignUpCertify.get();

        final User user = User.builder()
                .id(signUpCertify.getEmail())
                .password(signUpCertify.getPassword())
                .nickname(signUpCertify.getNickname())
                .build();
        userRepository.save(user);
        signUpCertifyRepository.delete(signUpCertify);
        return true;
    }

}
