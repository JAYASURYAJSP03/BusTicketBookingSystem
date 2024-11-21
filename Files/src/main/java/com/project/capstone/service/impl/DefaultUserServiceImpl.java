package com.project.capstone.service.impl;

import com.project.capstone.dto.UserRegisteredDTO;
import com.project.capstone.entity.Role;
import com.project.capstone.entity.User;
import com.project.capstone.repository.RoleRepository;
import com.project.capstone.repository.UserRepository;
import com.project.capstone.security.JwtUtil;
import com.project.capstone.service.DefaultUserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class DefaultUserServiceImpl implements DefaultUserService {

    private UserRepository userRepository;


    private RoleRepository roleRepository;

    private BCryptPasswordEncoder passwordEncoder;

    private final JwtUtil jwtUtil;

    public DefaultUserServiceImpl(@Lazy JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }



    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(email).get();
        if(user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesToAuthorities(user.getRole()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Set<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRole())).collect(Collectors.toList());
    }

    @Override
    public User save(UserRegisteredDTO userRegisteredDTO) {

        Role role = new Role();
        if(userRegisteredDTO.getRole().equals("USER")) {
            role = roleRepository.findByRole("USER");
        }
        else if(userRegisteredDTO.getRole().equals("ADMIN")) {
            role = roleRepository.findByRole("ADMIN");
        }
        User user = new User();
        user.setEmail(userRegisteredDTO.getEmail_id());
        user.setName(userRegisteredDTO.getName());
        user.setPassword(passwordEncoder.encode(userRegisteredDTO.getPassword()));
        user.setRole(role);


        return userRepository.save(user);
    }

}
