package com.ign.springcloud.msvc.oauth.services;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.ign.libs.msvc.commons.entity.User;

import io.micrometer.tracing.Tracer;

import org.springframework.http.MediaType;

@Service
public class UsersService implements UserDetailsService {

    private final Logger log = LoggerFactory.getLogger(UsersService.class);

    @Autowired
    private WebClient client;

    @Autowired
    private Tracer tracer;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            Map<String, String> params = Map.of("username", username);
            User user = client
                    .get()
                    .uri("/username/{username}", params)
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .bodyToMono(User.class)
                    .block();
            List<GrantedAuthority> authorities = user.getRoles().stream()
                    .map(role -> new SimpleGrantedAuthority(role.getName()))
                    .collect(Collectors.toList());
                    log.info("User found: " + user.getUsername());
                    tracer.currentSpan().tag("user.login.username", user.getUsername());
            return new org.springframework.security.core.userdetails.User(
                    user.getUsername(), user.getPassword(), user.isEnabled(), true, true, true, authorities);
        } catch (Exception e) {
            log.error("User not found: " + username);
            tracer.currentSpan().tag("error.login.message", "User not found: " + username);
            throw new UsernameNotFoundException("User not found");
        }
    }

}
