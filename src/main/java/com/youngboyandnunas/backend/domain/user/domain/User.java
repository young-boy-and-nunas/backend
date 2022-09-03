package com.youngboyandnunas.backend.domain.user.domain;

import com.youngboyandnunas.backend.domain.cheer.domain.Cheer;
import com.youngboyandnunas.backend.domain.worry.domain.Worry;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

    private int luckyPoint;

    private int state;

    @Builder
    public User(String id, String password, int luckyPoint, int state) {
        this.id = id;
        this.password = password;
        this.luckyPoint = luckyPoint;
        this.state = state;
    }

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Worry> worryList;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Cheer> cheerList;

}
