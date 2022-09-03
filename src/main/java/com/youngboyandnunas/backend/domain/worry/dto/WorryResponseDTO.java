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
    private String nickname;

    @Builder
    public WorryResponseDTO(Long worrySeq, String contents, String imgUrl, String nickname) {
        this.worrySeq = worrySeq;
        this.contents = contents;
        this.imgUrl = imgUrl;
        this.nickname = nickname;
    }

}
