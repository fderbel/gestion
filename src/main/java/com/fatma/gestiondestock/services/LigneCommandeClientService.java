package com.fatma.gestiondestock.services;

import java.util.List;

import com.fatma.gestiondestock.dto.LigneCommandeClientDto;

public interface LigneCommandeClientService {

	LigneCommandeClientDto save(LigneCommandeClientDto lignecommandeClientDto);

	LigneCommandeClientDto findById(Integer id);

	List<LigneCommandeClientDto> findAll();

	void delete(Integer id);
}
