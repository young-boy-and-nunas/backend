package com.youngboyandnunas.backend.domain.cheer.domain;

import com.youngboyandnunas.backend.domain.user.domain.User;
import com.youngboyandnunas.backend.domain.worry.domain.Worry;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
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

    private Date insertDate;

    @Builder
    public Cheer(Worry worry, User user, String contents, String imgUrl, String audioUrl) {
        this.worry = worry;
        this.user = user;
        this.contents = contents;
        this.imgUrl = imgUrl;
        this.audioUrl = audioUrl;
        this.readCheck = false;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public void setAudioUrl(String audioUrl) {
        this.audioUrl = audioUrl;
    }

    public void setUser(User user){
        this.user = user;
    }

    public void setWorry(Worry worry){
        this.worry = worry;
    }

    public void updateCheck(){
        this.readCheck = true;
    }

}
