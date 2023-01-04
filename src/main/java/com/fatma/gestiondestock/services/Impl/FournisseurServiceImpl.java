package com.fatma.gestiondestock.services.Impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.fatma.gestiondestock.dto.FournisseurDto;
import com.fatma.gestiondestock.exception.EntityNotFoundException;
import com.fatma.gestiondestock.exception.ErrorCodes;
import com.fatma.gestiondestock.mapper.FournisseurDtoFournisseurMapper;
import com.fatma.gestiondestock.model.Fournisseur;
import com.fatma.gestiondestock.repository.FournisseurRepository;
import com.fatma.gestiondestock.services.FournisseurService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FournisseurServiceImpl implements FournisseurService {

	private FournisseurRepository fournisseurRepository;

	public FournisseurServiceImpl(FournisseurRepository fournisseurRepository) {
		this.fournisseurRepository = fournisseurRepository;
	}

	@Override
	public FournisseurDto save(FournisseurDto fournisseurDto) {
		return FournisseurDtoFournisseurMapper.INSTANCE.fournisseurToFournisseurDto(fournisseurRepository
				.save(FournisseurDtoFournisseurMapper.INSTANCE.fournisseurDtoToFournisseur(fournisseurDto)));

	}

	@Override
	public FournisseurDto findById(Integer id) {
		if (id == null) {
			log.error("Fournisseur ID est null");
			return null;
		}
		Optional<Fournisseur> fournisseur = fournisseurRepository.findById(id);
		return Optional.of(FournisseurDtoFournisseurMapper.INSTANCE.fournisseurToFournisseurDto(fournisseur.get()))
				.orElseThrow(() -> new EntityNotFoundException("id not found ", ErrorCodes.ARTICLE_NOT_FOUND));
	}

	@Override
	public List<FournisseurDto> findAll() {
		return fournisseurRepository.findAll().stream()
				.map(FournisseurDtoFournisseurMapper.INSTANCE::fournisseurToFournisseurDto)
				.collect(Collectors.toList());
	}

	@Override
	public void delete(Integer id) {
		if (id == null) {
			log.error("Fournisseur ID est null");
			return;

		}
		fournisseurRepository.deleteById(id);

	}

}
