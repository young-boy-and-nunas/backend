package com.youngboyandnunas.backend.domain.user.service;

import com.youngboyandnunas.backend.domain.user.dao.UserRepository;
import com.youngboyandnunas.backend.domain.user.domain.User;
import com.youngboyandnunas.backend.domain.user.dto.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponse getUser(Long userId) {
        final User user = userRepository.findById(userId).get();
        return new UserResponse(user.getId(), user.getNickname());
    }

    public void withThrowUser(Long id) {
        userRepository.deleteById(id);
    }

}
