package com.fatma.gestiondestock.services;

import java.util.List;

import com.fatma.gestiondestock.dto.UtilisateurDto;

public interface UtilisateurService {

	UtilisateurDto save(UtilisateurDto utilisateurDto);

	UtilisateurDto findById(Integer id);

	List<UtilisateurDto> findAll();

	void delete(Integer id);
}
