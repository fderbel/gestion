package com.fatma.gestiondestock.services;

import java.util.List;

import com.fatma.gestiondestock.dto.CommandeClientDto;

public interface CommandeClientService {

	CommandeClientDto save(CommandeClientDto commandeClientDto);

	CommandeClientDto findById(Integer id);

	List<CommandeClientDto> findAll();

	void delete(Integer id);
}
