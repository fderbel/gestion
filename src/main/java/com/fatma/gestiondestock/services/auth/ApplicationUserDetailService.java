package com.fatma.gestiondestock.services.auth;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fatma.gestiondestock.exception.EntityNotFoundException;
import com.fatma.gestiondestock.exception.ErrorCodes;
import com.fatma.gestiondestock.model.Utilisateur;
import com.fatma.gestiondestock.repository.UtilisateurRepository;

@Service
public class ApplicationUserDetailService implements UserDetailsService {

	@Autowired
	UtilisateurRepository utilisateurRepository;

	@Autowired
	@Qualifier("password")
	PasswordEncoder passwordEncode;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Utilisateur user = utilisateurRepository.findByEmail(username).orElseThrow(
				() -> new EntityNotFoundException("aucun user with mail", ErrorCodes.UTILISATEUR_NOT_FOUND));
		// passwordEncoder().encode("javainuse")

		return new User(user.getEmail(), passwordEncode.encode(user.getMotDePass()), Collections.emptyList());
	}

}
