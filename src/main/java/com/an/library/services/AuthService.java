package com.an.library.services;

import com.an.library.DTO.RegistrationRequest;
import com.an.library.models.Role;
import com.an.library.models.User;
import com.an.library.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void register(RegistrationRequest request) {
        if (!request.getPassword().equals(request.getConfirmPassword())){
            throw new IllegalArgumentException("Пароль не совпадают");
        }

        if (userRepository.findByUsername(request.getUsername()).isPresent()){
            throw new IllegalArgumentException("Пользователь уже существует");
        }


        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(Role.USER);

        userRepository.save(user);
    }

}
