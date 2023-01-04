package com.fatma.gestiondestock.services;

import java.util.List;

import com.fatma.gestiondestock.dto.LigneCommandeFournisseurDto;

public interface LigneCommandeFournisseurService {

	LigneCommandeFournisseurDto save(LigneCommandeFournisseurDto lignecommandeFournisseurDto);

	LigneCommandeFournisseurDto findById(Integer id);

	List<LigneCommandeFournisseurDto> findAll();

	void delete(Integer id);
}
