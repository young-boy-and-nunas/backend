package com.youngboyandnunas.backend.domain.user.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SignUpRequest {

    private String nickname;
    private String email;
    private String password;

}
