package com.fatma.gestiondestock.services.Impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.fatma.gestiondestock.dto.ClientDto;
import com.fatma.gestiondestock.exception.EntityNotFoundException;
import com.fatma.gestiondestock.exception.ErrorCodes;
import com.fatma.gestiondestock.mapper.ClientDtoClientMapper;
import com.fatma.gestiondestock.model.Client;
import com.fatma.gestiondestock.repository.ClientRepository;
import com.fatma.gestiondestock.services.ClientService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ClientServiceImpl implements ClientService {

	private ClientRepository clientRepository;

	public ClientServiceImpl(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}

	@Override
	public ClientDto save(ClientDto clientDto) {
		return ClientDtoClientMapper.INSTANCE
				.clientToClientDto(clientRepository.save(ClientDtoClientMapper.INSTANCE.clientDtoToClient(clientDto)));

	}

	@Override
	public ClientDto findById(Integer id) {
		if (id == null) {
			log.error("Client ID est null");
			throw new EntityNotFoundException("Not Found Client", ErrorCodes.CLIENT_NOT_FOUND);
		}
		Optional<Client> client = clientRepository.findById(id);
		return Optional.of(ClientDtoClientMapper.INSTANCE.clientToClientDto(client.get()))
				.orElseThrow(() -> new EntityNotFoundException("id not found ", ErrorCodes.ARTICLE_NOT_FOUND));
	}

	@Override
	public List<ClientDto> findAll() {
		return clientRepository.findAll().stream().map(ClientDtoClientMapper.INSTANCE::clientToClientDto)
				.collect(Collectors.toList());
	}

	@Override
	public void delete(Integer id) {
		if (id == null) {
			log.error("Client ID est null");
			return;

		}
		clientRepository.deleteById(id);

	}

}
