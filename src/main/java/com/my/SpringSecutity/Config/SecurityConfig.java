package com.my.SpringSecutity.Config;

import com.my.SpringSecutity.Security.AutoProvidor;
import com.my.SpringSecutity.Server.UserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserServer providor;

    @Autowired
    public SecurityConfig(UserServer providor) {
        this.providor = providor;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/auto/login", "/auto/regist", "/error","/api","/api/id").permitAll() //по умолчанию разрешается допуск к этим страницам
                .anyRequest().hasAnyRole("USER","ADMIN")
               // .anyRequest().authenticated() //это строчка указывает что нужно аутентефицирован для других страниц
                .and()// связь настройки
                .formLogin().loginPage("/auto/login")// открыть страницу для ввода
                .loginProcessingUrl("/progreslogin")// переходит на эту страницу
                .defaultSuccessUrl("/first", true) //если успешно то на страницу hello
                .failureUrl("/auto/login?error") // а если провал то вернуть эту же страницу и после вывести ошибку error
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/auto/login")
        ;

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(providor)
                .passwordEncoder(getPasswordEncoder());
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
