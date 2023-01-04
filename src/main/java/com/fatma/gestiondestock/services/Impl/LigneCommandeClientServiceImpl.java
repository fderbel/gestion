package com.fatma.gestiondestock.services.Impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.fatma.gestiondestock.dto.LigneCommandeClientDto;
import com.fatma.gestiondestock.exception.EntityNotFoundException;
import com.fatma.gestiondestock.exception.ErrorCodes;
import com.fatma.gestiondestock.mapper.LigneCommandeClientDtoLigneCommandeClientMapper;
import com.fatma.gestiondestock.model.LigneCommandeClient;
import com.fatma.gestiondestock.repository.LigneCommandeClientRepository;
import com.fatma.gestiondestock.services.LigneCommandeClientService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class LigneCommandeClientServiceImpl implements LigneCommandeClientService {

	private LigneCommandeClientRepository ligneCommandeClientRepository;

	public LigneCommandeClientServiceImpl(LigneCommandeClientRepository ligneCommandeClientRepository) {
		this.ligneCommandeClientRepository = ligneCommandeClientRepository;
	}

	@Override
	public LigneCommandeClientDto save(LigneCommandeClientDto ligneCommandeClientDto) {

		LigneCommandeClient ligneCommandeClient = ligneCommandeClientRepository
				.save(LigneCommandeClientDtoLigneCommandeClientMapper.INSTANCE
						.lignecommandeClientDtoToLigneCommandeClient(ligneCommandeClientDto));
		return LigneCommandeClientDtoLigneCommandeClientMapper.INSTANCE
				.lignecommandeClientToLigneCommandeClientDto(ligneCommandeClient);

	}

	@Override
	public LigneCommandeClientDto findById(Integer id) {
		if (id == null) {
			log.error("LigneCommandeClient ID est null");
			return null;
		}
		Optional<LigneCommandeClient> ligneCommandeClient = ligneCommandeClientRepository.findById(id);
		return Optional
				.of(LigneCommandeClientDtoLigneCommandeClientMapper.INSTANCE
						.lignecommandeClientToLigneCommandeClientDto(ligneCommandeClient.get()))
				.orElseThrow(() -> new EntityNotFoundException("id not found ", ErrorCodes.ARTICLE_NOT_FOUND));
	}

	@Override
	public List<LigneCommandeClientDto> findAll() {
		return ligneCommandeClientRepository.findAll().stream().map(
				LigneCommandeClientDtoLigneCommandeClientMapper.INSTANCE::lignecommandeClientToLigneCommandeClientDto)
				.collect(Collectors.toList());
	}

	@Override
	public void delete(Integer id) {
		if (id == null) {
			log.error("LigneCommandeClient ID est null");
			return;

		}
		ligneCommandeClientRepository.deleteById(id);

	}

}
