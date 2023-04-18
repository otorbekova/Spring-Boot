package com.my.SpringSecutity.Controller;

import com.my.SpringSecutity.Server.ServerStandartUser;
import com.my.SpringSecutity.Validator.UserValidator;
import com.my.SpringSecutity.models.UserModels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/auto")
public class Auto {

    private final ServerStandartUser serverStandartUser;
    private final UserValidator valid;
    @Autowired
    public Auto(ServerStandartUser serverStandartUser, UserValidator valid) {
        this.serverStandartUser = serverStandartUser;
        this.valid = valid;
    }

    @GetMapping("/login")
    public String loginPage() {

        return "aut/login";
    }

    @GetMapping("/regist")
    public String registrationPage(@ModelAttribute("keyReg") UserModels userModels) {
        return "aut/reg";
    }

    @PostMapping("/regist")
    public String performRegistration(@ModelAttribute("keyReg") @Valid UserModels userModels,
                      BindingResult bindingResult) {
        valid.validate(userModels,bindingResult);
        if (bindingResult.hasErrors()) {
            return "redirect:/auto/regist";
        }
        serverStandartUser.saveUser(userModels);
        return "redirect:/aut/login";
    }
}
