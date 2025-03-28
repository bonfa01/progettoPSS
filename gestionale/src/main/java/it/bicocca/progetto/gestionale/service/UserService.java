package it.bicocca.progetto.gestionale.service;

import it.bicocca.progetto.gestionale.model.User;
import it.bicocca.progetto.gestionale.repository.UserRepository;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    public User registerUser(String nome, 
    						 String cognome, 		
    						 String email, 
    						 String password, 
    						 String numeroTelefono, 
    						 LocalDate dataNascita, 
    						 String sesso, 
    						 String residenza, 
    						 String role) {
        String emailLower = email.toLowerCase().trim();
        if (userRepository.existsByEmail(emailLower)) {
            throw new RuntimeException("Email già in uso!");
        }

        String encodedPassword = passwordEncoder.encode(password);
        User user = new User(nome, cognome, emailLower, encodedPassword, numeroTelefono, dataNascita, sesso, residenza, role);
		return userRepository.save(user);
	}
    

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public void aggiornaUtente(User user) {
        userRepository.save(user);
    }
}
