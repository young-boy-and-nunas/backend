package com.youngboyandnunas.backend.domain.user.service;

import com.youngboyandnunas.backend.domain.user.dao.SignUpCertifyRepository;
import com.youngboyandnunas.backend.domain.user.dao.UserRepository;
import com.youngboyandnunas.backend.domain.user.domain.SignUpCertify;
import com.youngboyandnunas.backend.domain.user.domain.User;
import com.youngboyandnunas.backend.domain.user.dto.LoginRequest;
import com.youngboyandnunas.backend.domain.user.dto.LoginResponse;
import com.youngboyandnunas.backend.domain.user.dto.SignUpRequest;
import com.youngboyandnunas.backend.global.exception.ErrorCode;
import com.youngboyandnunas.backend.global.exception.GlobalException;
import com.youngboyandnunas.backend.global.security.service.JwtTokenProvider;
import com.youngboyandnunas.backend.infra.mail.MailContentProvider;
import com.youngboyandnunas.backend.infra.mail.MailSendFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final PasswordEncoder passwordEncoder;
    private final MailSendFacade mailSendFacade;
    private final MailContentProvider mailContentProvider;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;
    private final SignUpCertifyRepository signUpCertifyRepository;

    public LoginResponse login(LoginRequest request) {
        final String email = request.getEmail();
        final String password = request.getPassword();

        final User user = userRepository.findById(email)
                .orElseThrow(() -> new GlobalException(ErrorCode.NOT_FOUND_ERROR));

        if(!passwordEncoder.matches(password, user.getPassword()))
            throw new GlobalException(ErrorCode.UNAUTHORIZED_ERROR);

        final String access = jwtTokenProvider.generateAccessToken(user.getUserSeq());
        final String refresh = jwtTokenProvider.generateRefreshToken(user.getUserSeq());

        return new LoginResponse(access, refresh);
    }

    public void signUp(SignUpRequest request) {
        final String email = request.getEmail();
        final String nickname = request.getNickname();

        if (userRepository.existsById(email) || signUpCertifyRepository.findByEmail(email) != null)
            throw new GlobalException(ErrorCode.ALL_ALREADY_EXISTS);

        final SignUpCertify signUpCertify = SignUpCertify.builder()
                .email(email)
                .password(passwordEncoder.encode(request.getPassword()))
                .nickname(nickname)
                .build();
        signUpCertifyRepository.save(signUpCertify);

        final String content = mailContentProvider.createSignUpContent(signUpCertify.getId().toString());
        mailSendFacade.sendHtmlMail(email, nickname + "님을 위한 위로해줘 우리병 회원가입 인증이 도착했습니다", content);
    }

}
