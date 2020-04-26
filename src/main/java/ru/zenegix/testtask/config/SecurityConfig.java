package ru.zenegix.testtask.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.zenegix.testtask.security.NonEncryptingPasswordEncoder;
import ru.zenegix.testtask.security.UserService;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserService userService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(this.userService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .sessionManagement().sessionFixation().none()

                .and()
                .authorizeRequests()
                .antMatchers("/app/**").authenticated()
                .anyRequest().permitAll()

                .and().httpBasic()
                .and().formLogin()
        ;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new NonEncryptingPasswordEncoder();
    }

}
