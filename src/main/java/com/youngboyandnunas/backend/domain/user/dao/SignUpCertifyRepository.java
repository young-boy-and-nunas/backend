package com.youngboyandnunas.backend.domain.user.dao;

import com.youngboyandnunas.backend.domain.user.domain.SignUpCertify;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface SignUpCertifyRepository extends CrudRepository<SignUpCertify, UUID> {
    SignUpCertify findByEmail(String email);
}
