package com.example.IndividualTrackProject.Service;

import com.example.IndividualTrackProject.Model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class AuthenticationUserDetailService implements UserDetailsService {

    private final UserService userService;
    @Override public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User apiUser = userService.readUserByUsername(username);
        if (apiUser == null) {
            throw new UsernameNotFoundException(username);
        }
        return new org.springframework.security.core.userdetails.User(apiUser.getUsername(), apiUser.getPassword(), Collections.emptyList());
    }
}