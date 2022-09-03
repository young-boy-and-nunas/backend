package com.youngboyandnunas.backend.domain.worry.controller;

import com.youngboyandnunas.backend.domain.worry.dto.CreateWorryRequestDto;
import com.youngboyandnunas.backend.domain.worry.dto.GetRandomWorryResponseDto;
import com.youngboyandnunas.backend.domain.worry.service.WorryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/worry")
public class WorryController {

    private final WorryService worryService;

    @GetMapping("/")
    public ResponseEntity<GetRandomWorryResponseDto> getRandomWorry() {
        return ResponseEntity.ok(worryService.getRandomWorry());
    }

    @PostMapping("/")
    public void createWorry(CreateWorryRequestDto dto) {
        worryService.createWorry(dto);
    }

}
