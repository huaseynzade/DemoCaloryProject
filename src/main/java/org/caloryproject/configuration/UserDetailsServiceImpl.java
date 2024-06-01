package org.caloryproject.configuration;


import lombok.RequiredArgsConstructor;
import org.caloryproject.entity.UserEntity;
import org.caloryproject.enums.RoleEnum;
import org.caloryproject.repository.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = repository.findByUsername(username).orElseThrow();
        List<String> roles = new ArrayList<>();
        Set<RoleEnum> authorities = Set.of(user.getRole());
        for (RoleEnum authority : authorities) {
            roles.add(authority.name());
        }
        UserDetails userDetails;
        userDetails = User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .roles(roles.toArray(new String[0]))
                .build();
        return userDetails;
    }
}
