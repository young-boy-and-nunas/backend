package com.youngboyandnunas.backend.infra.mail;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class MailContentProvider {

    private final String signUpTemplate;

    public MailContentProvider(MailProperties mailProperties) throws IOException {
        signUpTemplate = getResourceByPath("templates/SignUpMail.html")
                .replace("{LINK}", mailProperties.getSignUpLink() + "?token={TOKEN}");
    }

    private String getResourceByPath(String path) throws IOException {
        byte[] bytes = new ClassPathResource(path).getInputStream().readAllBytes();
        return new String(bytes);
    }

    public String createSignUpContent(String token) {
        return signUpTemplate
                .replace("{TOKEN}", token);
    }

}
