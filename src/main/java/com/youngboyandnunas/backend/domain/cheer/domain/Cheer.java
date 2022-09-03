package com.youngboyandnunas.backend.domain.cheer.domain;

import com.youngboyandnunas.backend.domain.user.domain.User;
import com.youngboyandnunas.backend.domain.worry.domain.Worry;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Cheer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cheerSeq;

    @ManyToOne
    @JoinColumn(name = "worry_seq", nullable = false)
    private Worry worry;

    @ManyToOne
    @JoinColumn(name = "user_seq", nullable = false)
    private User user;

    @Column(length = 2040)
    private String contents;

    private String imgUrl;

    private String audioUrl;

    private boolean readCheck;

    @Builder
    public Cheer(Worry worry, User user, String contents, String imgUrl, String audioUrl) {
        this.worry = worry;
        this.user = user;
        this.contents = contents;
        this.imgUrl = imgUrl;
        this.audioUrl = audioUrl;
        this.readCheck = false;
    }

}
