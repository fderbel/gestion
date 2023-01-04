package com.fatma.gestiondestock.services.Impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.fatma.gestiondestock.dto.LigneCommandeFournisseurDto;
import com.fatma.gestiondestock.exception.EntityNotFoundException;
import com.fatma.gestiondestock.exception.ErrorCodes;
import com.fatma.gestiondestock.mapper.LigneCommandeFournisseurDtoLigneCommandeFournisseurMapper;
import com.fatma.gestiondestock.model.LigneCommandeFournisseur;
import com.fatma.gestiondestock.repository.LigneCommandeFournisseurRepository;
import com.fatma.gestiondestock.services.LigneCommandeFournisseurService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class LigneCommandeFournisseurServiceImpl implements LigneCommandeFournisseurService {

	private LigneCommandeFournisseurRepository ligneCommandeFournisseurRepository;

	public LigneCommandeFournisseurServiceImpl(LigneCommandeFournisseurRepository ligneCommandeFournisseurRepository) {
		this.ligneCommandeFournisseurRepository = ligneCommandeFournisseurRepository;
	}

	@Override
	public LigneCommandeFournisseurDto save(LigneCommandeFournisseurDto ligneCommandeFournisseurDto) {

		LigneCommandeFournisseur ligneCommandeFournisseur = ligneCommandeFournisseurRepository
				.save(LigneCommandeFournisseurDtoLigneCommandeFournisseurMapper.INSTANCE
						.lignecommandeFournisseurDtoToLigneCommandeFournisseur(ligneCommandeFournisseurDto));
		return LigneCommandeFournisseurDtoLigneCommandeFournisseurMapper.INSTANCE
				.lignecommandeFournisseurToLigneCommandeFournisseurDto(ligneCommandeFournisseur);

	}

	@Override
	public LigneCommandeFournisseurDto findById(Integer id) {
		if (id == null) {
			log.error("LigneCommandeFournisseur ID est null");
			return null;
		}
		Optional<LigneCommandeFournisseur> ligneCommandeFournisseur = ligneCommandeFournisseurRepository.findById(id);
		return Optional
				.of(LigneCommandeFournisseurDtoLigneCommandeFournisseurMapper.INSTANCE
						.lignecommandeFournisseurToLigneCommandeFournisseurDto(ligneCommandeFournisseur.get()))
				.orElseThrow(() -> new EntityNotFoundException("id not found ", ErrorCodes.ARTICLE_NOT_FOUND));
	}

	@Override
	public List<LigneCommandeFournisseurDto> findAll() {
		return ligneCommandeFournisseurRepository.findAll().stream().map(
				LigneCommandeFournisseurDtoLigneCommandeFournisseurMapper.INSTANCE::lignecommandeFournisseurToLigneCommandeFournisseurDto)
				.collect(Collectors.toList());
	}

	@Override
	public void delete(Integer id) {
		if (id == null) {
			log.error("LigneCommandeFournisseur ID est null");
			return;

		}
		ligneCommandeFournisseurRepository.deleteById(id);

	}

}
