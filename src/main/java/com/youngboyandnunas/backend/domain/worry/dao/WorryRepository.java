package com.youngboyandnunas.backend.domain.worry.dao;

import com.youngboyandnunas.backend.domain.worry.domain.Worry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface WorryRepository extends JpaRepository<Worry, Long> {

    @Query(
            value = "SELECT * FROM worry w " +
                    "WHERE NOT EXISTS (SELECT * FROM history WHERE worry_seq = w.worry_seq AND user_seq = :userSeq) " +
                    "AND w.user_seq != :userSeq " +
                    "ORDER BY RAND() LIMIT 1",
            nativeQuery = true
    )
    Worry getRandomWorry(@Param("userSeq") Long userSeq);

}
