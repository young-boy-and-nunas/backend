package com.youngboyandnunas.backend.domain.worry.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class GetRandomWorryResponseDto {

    private Long worrySeq;
    private String contents;
    private String imgUrl;

    @Builder
    public GetRandomWorryResponseDto(Long worrySeq, String contents, String imgUrl) {
        this.worrySeq = worrySeq;
        this.contents = contents;
        this.imgUrl = imgUrl;
    }

}
