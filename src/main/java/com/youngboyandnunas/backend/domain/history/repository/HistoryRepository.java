package com.youngboyandnunas.backend.domain.history.repository;

import com.youngboyandnunas.backend.domain.history.domain.History;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepository extends JpaRepository<History, Long> {

}
