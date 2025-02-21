package com.example.pid_2025.Config;

import java.util.*;

import com.example.pid_2025.entities.User;

import com.example.pid_2025.dal.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByLogin(username);
        return new org.springframework.security.core.userdetails.User(
                user.getLogin(), user.getPassword(),
                getGrantedAuthorities(user.getRole()));
    }
    private List<GrantedAuthority> getGrantedAuthorities(List<Role> roles) {
        List<GrantedAuthority> authorities = new ArrayList<>();

        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        }
        return authorities;
        }}















///*@Service
//public class CustomUserDetailsService implements UserDetailsService {
//    @Autowired
//    private UserRepository userRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        // Récupérez l'utilisateur depuis la base de données
//        User user = userRepository.findByLogin(username);
//
//        // Si l'utilisateur n'est pas trouvé, lancez une exception
//        if (user == null) {
//            throw new UsernameNotFoundException("User not found with username: " + username);
//        }
//
//        // Convertissez votre User en UserDetails
//        return new org.springframework.security.core.userdetails.User(
//                user.getLogin(), // Nom d'utilisateur
//                user.getPassword(), // Mot de passe
//                getGrantedAuthorities(user.getRole()) // Rôles
//        );
//    }
//    private List<GrantedAuthority> getGrantedAuthorities(String role) {
//        List<GrantedAuthority> authorities = new ArrayList<>();
//        authorities.add(new SimpleGrantedAuthority("ROLE_" + role)); // Ajoutez le rôle avec le préfixe "ROLE_"
//        return authorities;
//    }*/
