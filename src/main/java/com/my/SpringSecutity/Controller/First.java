package com.my.SpringSecutity.Controller;

import com.my.SpringSecutity.Config.SecurityConfig;
import com.my.SpringSecutity.Security.UserDetaiISU;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class First {

    @GetMapping("/first")
    public String Hello(){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        UserDetaiISU user=(UserDetaiISU) authentication.getPrincipal();
        System.out.println(user.getUser());
        return "first";
    }

    @GetMapping("/admin")
    public String adminPage(){
        return "admin";
    }
}
