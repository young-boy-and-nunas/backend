package com.youngboyandnunas.backend.domain.auto_cheer.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class AutoCheer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long autoCheerSeq;

    private String contents;

    private String imgUrl;

    @Builder
    public AutoCheer(String contents, String imgUrl) {
        this.contents = contents;
        this.imgUrl = imgUrl;
    }

}
