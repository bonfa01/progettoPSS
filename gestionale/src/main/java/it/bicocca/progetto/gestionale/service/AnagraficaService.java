package it.bicocca.progetto.gestionale.service;

import it.bicocca.progetto.gestionale.model.User;
import it.bicocca.progetto.gestionale.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnagraficaService {

	@Autowired
	private UserRepository userRepository;

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
}
