package ru.zenegix.testtask.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserService implements UserDetailsService {

    public static final String ADMIN_NAME = "admin";
    private final UserDetails adminUser;

    public UserService(@Value("${admin-password}") String adminPassword) {
        adminUser = new User(ADMIN_NAME, adminPassword, Collections.singleton(Role.ADMIN));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (username.equals(ADMIN_NAME)) {
            return this.adminUser;
        }

        throw new UsernameNotFoundException(username);
    }

}
