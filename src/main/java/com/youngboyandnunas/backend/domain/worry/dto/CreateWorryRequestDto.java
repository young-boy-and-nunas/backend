package com.youngboyandnunas.backend.domain.worry.dto;

import lombok.Builder;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

@Getter
public class CreateWorryRequestDto {

    private String contents;
    private MultipartFile imgUrl;
    private Long userSeq;

    @Builder
    public CreateWorryRequestDto(String contents, MultipartFile imgUrl, Long userSeq) {
        this.contents = contents;
        this.imgUrl = imgUrl;
        this.userSeq = userSeq;
    }

}
