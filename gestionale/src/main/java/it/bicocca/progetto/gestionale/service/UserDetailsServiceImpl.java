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
        // Forza l'email in minuscolo e rimuove spazi
        String emailLower = email.toLowerCase().trim();
        User appUser = userRepository.findByEmail(emailLower);
        if (appUser == null) {
            throw new UsernameNotFoundException("Utente non trovato con email: " + emailLower);
        }
        // Costruisce l'autorità partendo dal ruolo; ad esempio, se role è "ADMIN" restituisce "ROLE_ADMIN"
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + appUser.getRole().toUpperCase());
        return new org.springframework.security.core.userdetails.User(
            appUser.getEmail(),
            appUser.getPassword(),
            Collections.singletonList(authority)
        );
    }
}
