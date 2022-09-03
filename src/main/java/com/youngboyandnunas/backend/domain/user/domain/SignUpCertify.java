package com.youngboyandnunas.backend.domain.user.domain;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Id;
import java.util.UUID;

@Getter
@RedisHash(timeToLive = 300)
public class SignUpCertify {

    @Id
    private UUID id;

    private String email;

    private String password;

    private String nickname;

    @Builder
    public SignUpCertify(String email, String password, String nickname) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
    }

}
