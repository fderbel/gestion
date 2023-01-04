package com.fatma.gestiondestock.services;

import java.util.List;

import com.fatma.gestiondestock.dto.CommandeFournisseurDto;

public interface CommandeFournisseurService {

	CommandeFournisseurDto save(CommandeFournisseurDto commandeFournisseurDto);

	CommandeFournisseurDto findById(Integer id);

	List<CommandeFournisseurDto> findAll();

	void delete(Integer id);
}
