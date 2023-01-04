package com.fatma.gestiondestock.services.Impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.fatma.gestiondestock.dto.UtilisateurDto;
import com.fatma.gestiondestock.exception.EntityNotFoundException;
import com.fatma.gestiondestock.exception.ErrorCodes;
import com.fatma.gestiondestock.mapper.UtilisateurDtoUtilisateurMapper;
import com.fatma.gestiondestock.model.Utilisateur;
import com.fatma.gestiondestock.repository.UtilisateurRepository;
import com.fatma.gestiondestock.services.UtilisateurService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UtilisateurServiceImpl implements UtilisateurService {

	private UtilisateurRepository utilisateurRepository;

	public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository) {
		this.utilisateurRepository = utilisateurRepository;
	}

	@Override
	public UtilisateurDto save(UtilisateurDto utilisateurDto) {
		return UtilisateurDtoUtilisateurMapper.INSTANCE.utilisateurToUtilisateurDto(utilisateurRepository
				.save(UtilisateurDtoUtilisateurMapper.INSTANCE.utilisateurDtoToUtilisateur(utilisateurDto)));

	}

	@Override
	public UtilisateurDto findById(Integer id) {
		if (id == null) {
			log.error("Utilisateur ID est null");
			return null;
		}
		Optional<Utilisateur> utilisateur = utilisateurRepository.findById(id);
		return Optional.of(UtilisateurDtoUtilisateurMapper.INSTANCE.utilisateurToUtilisateurDto(utilisateur.get()))
				.orElseThrow(() -> new EntityNotFoundException("id not found ", ErrorCodes.ARTICLE_NOT_FOUND));
	}

	@Override
	public List<UtilisateurDto> findAll() {
		return utilisateurRepository.findAll().stream()
				.map(UtilisateurDtoUtilisateurMapper.INSTANCE::utilisateurToUtilisateurDto)
				.collect(Collectors.toList());
	}

	@Override
	public void delete(Integer id) {
		if (id == null) {
			log.error("Utilisateur ID est null");
			return;

		}
		utilisateurRepository.deleteById(id);

	}

}
