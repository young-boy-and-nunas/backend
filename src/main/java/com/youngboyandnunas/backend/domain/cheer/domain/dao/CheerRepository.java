package com.youngboyandnunas.backend.domain.cheer.domain.dao;

import com.youngboyandnunas.backend.domain.cheer.domain.Cheer;
import com.youngboyandnunas.backend.domain.user.domain.User;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CheerRepository extends CrudRepository<Cheer, Long> {

    @Query(" select c from Cheer c where c.user = :user " +
            "order by c.cheerSeq desc ")
    List<Cheer> getCheerByUserIdLimit20(User user, PageRequest pageRequest);

}
