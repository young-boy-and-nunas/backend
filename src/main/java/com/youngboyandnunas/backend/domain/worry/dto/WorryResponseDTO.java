package com.youngboyandnunas.backend.domain.worry.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class WorryResponseDTO {

    private Long worrySeq;
    private String contents;
    private String imgUrl;

    @Builder
    public WorryResponseDTO(Long worrySeq, String contents, String imgUrl) {
        this.worrySeq = worrySeq;
        this.contents = contents;
        this.imgUrl = imgUrl;
    }

}
