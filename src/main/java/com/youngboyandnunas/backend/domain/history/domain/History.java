package com.youngboyandnunas.backend.domain.history.domain;

import com.youngboyandnunas.backend.domain.user.domain.User;
import com.youngboyandnunas.backend.domain.worry.domain.Worry;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long historySeq;

    @ManyToOne
    @JoinColumn(name = "worry_seq", nullable = false)
    private Worry worry;

    @ManyToOne
    @JoinColumn(name = "user_seq", nullable = false)
    private User user;

    @Builder
    public History(Long historySeq, Worry worry, User user) {
        this.historySeq = historySeq;
        this.worry = worry;
        this.user = user;
    }

}
