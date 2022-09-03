package com.youngboyandnunas.backend.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("local")
class AwsS3ComponentTest {

    @Autowired
    AwsS3Component component;

    @Test
    void fileUploadTest(){

        File file = new File("C:\\Users\\82103\\Documents\\backend\\src\\main\\resources\\application-local.yml");

        String hello = component.getFileUrl("hello");



    }

}