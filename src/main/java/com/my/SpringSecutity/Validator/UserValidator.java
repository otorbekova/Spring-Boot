package com.my.SpringSecutity.Validator;

import com.my.SpringSecutity.Repository.UserRepository;
import com.my.SpringSecutity.Server.ServerStandartUser;
import com.my.SpringSecutity.Server.UserServer;
import com.my.SpringSecutity.models.UserModels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


@Component
public class UserValidator implements Validator {
    private final UserServer userRepository;

    @Autowired
    public UserValidator(UserServer userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return UserModels.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        UserModels models= (UserModels) o;
        try {
            userRepository.loadUserByUsername(models.getUserName());
        }catch (UsernameNotFoundException ignor){
            return;
        }
        errors.rejectValue("username","","Такой пользователь уже существует");

    }

/*
    @Override
    public <T> Set<ConstraintViolation<T>> validate(T object, Class<?>... groups) {
        return null;
    }

    @Override
    public <T> Set<ConstraintViolation<T>> validateProperty(T object, String propertyName, Class<?>... groups) {
        return null;
    }

    @Override
    public <T> Set<ConstraintViolation<T>> validateValue(Class<T> beanType, String propertyName, Object value, Class<?>... groups) {
        return null;
    }

    @Override
    public BeanDescriptor getConstraintsForClass(Class<?> clazz) {
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> type) {
        return null;
    }

    @Override
    public ExecutableValidator forExecutables() {
        return null;
    }*/


}
