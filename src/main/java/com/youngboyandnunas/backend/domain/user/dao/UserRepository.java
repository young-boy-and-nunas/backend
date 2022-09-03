package com.youngboyandnunas.backend.domain.user.dao;

import com.youngboyandnunas.backend.domain.user.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
