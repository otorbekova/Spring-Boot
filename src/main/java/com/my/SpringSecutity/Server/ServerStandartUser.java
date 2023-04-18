package com.my.SpringSecutity.Server;

import com.my.SpringSecutity.Repository.UserRepository;
import com.my.SpringSecutity.models.UserModels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServerStandartUser {
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    @Autowired
    public ServerStandartUser(UserRepository userRepository, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    @Transactional
    public void saveUser(UserModels userModels){
        userModels.setPassword(encoder.encode(userModels.getPassword()));
        userModels.setRole("ROLE_USER");
        userRepository.save(userModels);
    }
}
