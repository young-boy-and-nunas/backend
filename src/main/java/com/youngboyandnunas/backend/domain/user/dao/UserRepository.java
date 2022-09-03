package com.youngboyandnunas.backend.domain.user.dao;

import com.youngboyandnunas.backend.domain.user.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    boolean existsById(String id);
    Optional<User> findById(String id);
}
