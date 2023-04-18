package com.my.SpringSecutity.Security;

import com.my.SpringSecutity.Server.UserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;

@Component
public class AutoProvidor implements AuthenticationProvider {

    private final UserServer detaiISU;

    @Autowired
    public AutoProvidor(UserServer deta) {
        this.detaiISU = deta;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String us = authentication.getName();
        UserDetails userDetails = detaiISU.loadUserByUsername(us);

        String password = authentication.getCredentials().toString();
        if (!password.equals(userDetails.getPassword())){
            throw new BadCredentialsException("Incorrect password");
    }
       return new UsernamePasswordAuthenticationToken
                (userDetails,password, Collections.emptyList());
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
