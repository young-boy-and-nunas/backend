package com.youngboyandnunas.backend.domain.worry.service;

import com.youngboyandnunas.backend.domain.worry.dto.CreateWorryRequestDto;
import com.youngboyandnunas.backend.domain.worry.dto.WorryResponseDTO;

public interface WorryService {

    WorryResponseDTO getRandomWorry();

    void createWorry(CreateWorryRequestDto dto);

}
