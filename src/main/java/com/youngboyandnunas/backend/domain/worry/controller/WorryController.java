package com.youngboyandnunas.backend.domain.worry.controller;

import com.youngboyandnunas.backend.domain.worry.dto.CreateWorryRequestDto;
import com.youngboyandnunas.backend.domain.worry.dto.GetRandomWorryResponseDto;
import com.youngboyandnunas.backend.domain.worry.service.WorryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public void createWorry(@ModelAttribute CreateWorryRequestDto dto) {
        worryService.createWorry(dto);
    }

}
