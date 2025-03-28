package it.bicocca.progetto.gestionale.service;

import it.bicocca.progetto.gestionale.model.User;
import it.bicocca.progetto.gestionale.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import java.util.Collections;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    
    private final UserRepository userRepository;
    
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        String emailLower = email.toLowerCase().trim();
        User appUser = userRepository.findByEmail(emailLower);
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + appUser.getRole().toUpperCase());
        return new org.springframework.security.core.userdetails.User(
            appUser.getEmail(),
            appUser.getPassword(),
            Collections.singletonList(authority)
        );
    }
}
