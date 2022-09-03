package com.youngboyandnunas.backend.domain.cheer.domain.service;

import com.youngboyandnunas.backend.domain.cheer.domain.dto.CheerDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CheerServiceTest {

    @Autowired
    CheerService cheerService;
    
//    @Test
//    void mappingTest(){
//
//        List<CheerDTO> cheerDTOS = cheerService.selectLimit20Cheer(4L);
//        System.out.print(cheerDTOS.size());
//        System.out.print(cheerDTOS.get(0).toString());
//
//
//    }

}