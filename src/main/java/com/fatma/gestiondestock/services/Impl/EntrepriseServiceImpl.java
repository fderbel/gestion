package com.fatma.gestiondestock.services.Impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.fatma.gestiondestock.dto.EntrepriseDto;
import com.fatma.gestiondestock.exception.EntityNotFoundException;
import com.fatma.gestiondestock.exception.ErrorCodes;
import com.fatma.gestiondestock.mapper.EntrepriseDtoEntrepriseMapper;
import com.fatma.gestiondestock.model.Entreprise;
import com.fatma.gestiondestock.repository.EntrepriseRepository;
import com.fatma.gestiondestock.services.EntrepriseService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EntrepriseServiceImpl implements EntrepriseService {

	private EntrepriseRepository entrepriseRepository;

	public EntrepriseServiceImpl(EntrepriseRepository entrepriseRepository) {
		this.entrepriseRepository = entrepriseRepository;
	}

	@Override
	public EntrepriseDto save(EntrepriseDto entrepriseDto) {
		return EntrepriseDtoEntrepriseMapper.INSTANCE.entrepriseToEntrepriseDto(entrepriseRepository
				.save(EntrepriseDtoEntrepriseMapper.INSTANCE.entrepriseDtoToEntreprise(entrepriseDto)));

	}

	@Override
	public EntrepriseDto findById(Integer id) {
		if (id == null) {
			log.error("Entreprise ID est null");
			return null;
		}
		Optional<Entreprise> entreprise = entrepriseRepository.findById(id);
		return Optional.of(EntrepriseDtoEntrepriseMapper.INSTANCE.entrepriseToEntrepriseDto(entreprise.get()))
				.orElseThrow(() -> new EntityNotFoundException("id not found ", ErrorCodes.ARTICLE_NOT_FOUND));
	}

	@Override
	public List<EntrepriseDto> findAll() {
		return entrepriseRepository.findAll().stream()
				.map(EntrepriseDtoEntrepriseMapper.INSTANCE::entrepriseToEntrepriseDto).collect(Collectors.toList());
	}

	@Override
	public void delete(Integer id) {
		if (id == null) {
			log.error("Entreprise ID est null");
			return;

		}
		entrepriseRepository.deleteById(id);

	}

}
