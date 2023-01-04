package com.fatma.gestiondestock.services;

import java.util.List;

import com.fatma.gestiondestock.dto.ClientDto;

public interface ClientService {

	ClientDto save(ClientDto clientDto);

	ClientDto findById(Integer id);

	List<ClientDto> findAll();

	void delete(Integer id);
}
