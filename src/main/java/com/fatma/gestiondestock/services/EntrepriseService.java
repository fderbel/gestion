package com.fatma.gestiondestock.services;

import java.util.List;

import com.fatma.gestiondestock.dto.EntrepriseDto;

public interface EntrepriseService {

	EntrepriseDto save(EntrepriseDto entrepriseDto);

	EntrepriseDto findById(Integer id);

	List<EntrepriseDto> findAll();

	void delete(Integer id);
}
