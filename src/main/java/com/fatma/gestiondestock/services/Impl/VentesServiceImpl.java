package com.fatma.gestiondestock.services.Impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.fatma.gestiondestock.dto.VentesDto;
import com.fatma.gestiondestock.exception.EntityNotFoundException;
import com.fatma.gestiondestock.exception.ErrorCodes;
import com.fatma.gestiondestock.exception.InvalidEntityException;
import com.fatma.gestiondestock.mapper.LigneVenteDtoLigneVenteMapper;
import com.fatma.gestiondestock.mapper.VentesDtoVentesMapper;
import com.fatma.gestiondestock.model.LigneVente;
import com.fatma.gestiondestock.model.Ventes;
import com.fatma.gestiondestock.repository.ArticleRepository;
import com.fatma.gestiondestock.repository.LigneVenteRepository;
import com.fatma.gestiondestock.repository.VentesRepository;
import com.fatma.gestiondestock.services.VentesService;
import com.fatma.gestiondestock.validator.VentesValidator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class VentesServiceImpl implements VentesService {

	private VentesRepository ventesRepository;
	private LigneVenteRepository ligneVentesRepository;

	public VentesServiceImpl(VentesRepository ventesRepository, LigneVenteRepository ligneVentesRepository,
			ArticleRepository articleRepository) {
		this.ventesRepository = ventesRepository;
		this.ligneVentesRepository = ligneVentesRepository;
	}

	@Override
	public VentesDto save(VentesDto ventesDto) {
		List<String> errors = VentesValidator.validate(ventesDto);
		if (!errors.isEmpty()) {
			log.error("Ventes not valide {}", ventesDto);
			throw new InvalidEntityException("Ventes n'est pas valid", ErrorCodes.ARTICLE_NOT_VALID, errors);
		}

		/*
		 * Optional<Client> client =
		 * clientRepository.findById(ventesDto.getClient().getId()); if
		 * (!client.isPresent()) { log.warn("client with ID is not found"); throw new
		 * EntityNotFoundException("client with ID is not found "); } List<String>
		 * errorsAricle = new ArrayList<>(); if (!ventesDto.getLigneVentess().isEmpty())
		 * { ventesDto.getLigneVentess().forEach(ligneventes ->{ if
		 * (ligneventes.getArticle()!= null) { Optional<Article> article =
		 * articleRepository.findById(ligneventes.getArticle().getId()); if
		 * (!article.isPresent()) {
		 * errorsAricle.add("l'article avec Id"+ligneventes.getArticle().getId()
		 * +"is not found"); }
		 * 
		 * } }); } if (!errorsAricle.isEmpty()) { log.warn("article not found "); throw
		 * new InvalidEntityException("article not found", ErrorCodes.ARTICLE_NOT_FOUND,
		 * errorsAriclegfn);
		 * 
		 * }
		 */

		Ventes savedventes = ventesRepository.save(VentesDtoVentesMapper.INSTANCE.ventesDtoToVentes(ventesDto));
		VentesDto savedventesDto = VentesDtoVentesMapper.INSTANCE.ventesToVentesDto(savedventes);
		if (!ventesDto.getLigneVentes().isEmpty()) {
			ventesDto.getLigneVentes().forEach(ligneventes -> {

				LigneVente ligneVentessaved = LigneVenteDtoLigneVenteMapper.INSTANCE
						.ligneVenteDtoToLigneVente(ligneventes);
				ligneVentessaved.setVente(savedventes);
				ligneVentesRepository.save(ligneVentessaved);
			});

		}
		return savedventesDto;

	}

	@Override
	public VentesDto findById(Integer id) {
		if (id == null) {
			log.error("Ventes ID est null");
			return null;
		}
		Optional<Ventes> ventes = ventesRepository.findById(id);
		return Optional.of(VentesDtoVentesMapper.INSTANCE.ventesToVentesDto(ventes.get()))
				.orElseThrow(() -> new EntityNotFoundException("id not found ", ErrorCodes.ARTICLE_NOT_FOUND));
	}

	@Override
	public List<VentesDto> findAll() {
		return ventesRepository.findAll().stream().map(VentesDtoVentesMapper.INSTANCE::ventesToVentesDto)
				.collect(Collectors.toList());
	}

	@Override
	public void delete(Integer id) {
		if (id == null) {
			log.error("Ventes ID est null");
			return;

		}
		ventesRepository.deleteById(id);

	}

}
