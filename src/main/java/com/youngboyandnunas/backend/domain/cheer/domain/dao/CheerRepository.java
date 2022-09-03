package com.youngboyandnunas.backend.domain.cheer.domain.dao;

import com.youngboyandnunas.backend.domain.cheer.domain.Cheer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheerRepository extends CrudRepository<Cheer, Long> {
}
