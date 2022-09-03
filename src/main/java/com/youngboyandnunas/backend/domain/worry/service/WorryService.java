package com.youngboyandnunas.backend.domain.worry.service;

import com.youngboyandnunas.backend.domain.worry.dto.CreateWorryRequestDto;
import com.youngboyandnunas.backend.domain.worry.dto.GetRandomWorryResponseDto;

public interface WorryService {

    GetRandomWorryResponseDto getRandomWorry();

    void createWorry(CreateWorryRequestDto dto);

}
