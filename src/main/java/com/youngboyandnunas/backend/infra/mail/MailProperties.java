package com.youngboyandnunas.backend.infra.mail;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

import javax.mail.internet.InternetAddress;
import java.io.UnsupportedEncodingException;

@Getter
@ConstructorBinding
@ConfigurationProperties(prefix = "spring.mail")
public class MailProperties {

    private final InternetAddress fromAddress;
    private final String signUpLink;

    public MailProperties(String username, String signUpLink) throws UnsupportedEncodingException {
        this.fromAddress = new InternetAddress(username, "위로해줘 유리병");
        this.signUpLink = signUpLink;
    }

}
