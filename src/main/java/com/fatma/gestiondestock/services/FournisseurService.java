package com.fatma.gestiondestock.services;

import java.util.List;

import com.fatma.gestiondestock.dto.FournisseurDto;

public interface FournisseurService {

	FournisseurDto save(FournisseurDto fournisseurDto);

	FournisseurDto findById(Integer id);

	List<FournisseurDto> findAll();

	void delete(Integer id);
}
