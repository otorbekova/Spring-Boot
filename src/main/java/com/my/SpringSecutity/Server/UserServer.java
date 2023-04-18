package com.my.SpringSecutity.Server;

import com.my.SpringSecutity.Repository.UserRepository;
import com.my.SpringSecutity.Security.UserDetaiISU;
import com.my.SpringSecutity.models.UserModels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServer implements UserDetailsService {
    private final UserRepository user;

    @Autowired
    public UserServer(UserRepository user){
        this.user=user;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserModels>optionalUserModels =user.findByUserName(username);
        if(optionalUserModels.isEmpty()) {
            throw new UsernameNotFoundException(
                    "User not found!");
        }
        return new UserDetaiISU(optionalUserModels.get());
    }

}
