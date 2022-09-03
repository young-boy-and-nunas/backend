package com.youngboyandnunas.backend.domain.user.domain;

import com.youngboyandnunas.backend.domain.cheer.domain.Cheer;
import com.youngboyandnunas.backend.domain.worry.domain.Worry;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userSeq;

    private String id;

    private String password;

    private String nickname;

    private int luckyPoint;

    @Setter
    private int state;

    @Builder
    public User(String id, String password, String nickname) {
        this.id = id;
        this.password = password;
        this.nickname = nickname;
        this.luckyPoint = 10;
        this.state = 0;
    }

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Worry> worryList;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Cheer> cheerList;

}
