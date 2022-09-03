package com.youngboyandnunas.backend.domain.worry.domain;

import com.youngboyandnunas.backend.domain.cheer.domain.Cheer;
import com.youngboyandnunas.backend.domain.history.domain.History;
import com.youngboyandnunas.backend.domain.user.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Worry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long worrySeq;

    @ManyToOne
    @JoinColumn(name = "user_seq", nullable = false)
    private User user;

    @Column(length = 2040)
    private String contents;

    private String imgUrl;

    @Builder
    public Worry(User user, String contents, String imgUrl) {
        this.user = user;
        this.contents = contents;
        this.imgUrl = imgUrl;
    }

    @OneToMany(mappedBy = "worry", cascade = CascadeType.REMOVE)
    private List<Cheer> cheerList;

    @OneToMany(mappedBy = "worry", cascade = CascadeType.REMOVE)
    private List<History> historyList;

}
