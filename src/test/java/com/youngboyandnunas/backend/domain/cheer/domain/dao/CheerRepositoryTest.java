package com.youngboyandnunas.backend.domain.cheer.domain.dao;

import com.youngboyandnunas.backend.domain.cheer.domain.Cheer;
import com.youngboyandnunas.backend.domain.user.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CheerRepositoryTest {

    @Autowired
    CheerRepository cheerRepository;

    @Test
    void findByUserIdTest(){

        User user = new User();
        List<Cheer> allByUserId =  cheerRepository.getCheerByUserIdLimit20(user, PageRequest.of(0, 10));

    }

}