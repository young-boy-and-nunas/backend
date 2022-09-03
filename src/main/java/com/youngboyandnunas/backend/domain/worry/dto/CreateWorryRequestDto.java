package com.youngboyandnunas.backend.domain.worry.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
public class CreateWorryRequestDto {

    private String contents;
    private MultipartFile imgFile;
    private Long userSeq;

}
