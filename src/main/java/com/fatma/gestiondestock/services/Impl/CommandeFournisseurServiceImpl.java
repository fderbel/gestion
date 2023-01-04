package com.fatma.gestiondestock.services.Impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.fatma.gestiondestock.dto.CommandeFournisseurDto;
import com.fatma.gestiondestock.exception.EntityNotFoundException;
import com.fatma.gestiondestock.exception.ErrorCodes;
import com.fatma.gestiondestock.exception.InvalidEntityException;
import com.fatma.gestiondestock.mapper.CommandeFournisseurDtoCommandeFournisseurMapper;
import com.fatma.gestiondestock.mapper.LigneCommandeFournisseurDtoLigneCommandeFournisseurMapper;
import com.fatma.gestiondestock.model.CommandeFournisseur;
import com.fatma.gestiondestock.model.LigneCommandeFournisseur;
import com.fatma.gestiondestock.repository.ArticleRepository;
import com.fatma.gestiondestock.repository.CommandeFournisseurRepository;
import com.fatma.gestiondestock.repository.LigneCommandeFournisseurRepository;
import com.fatma.gestiondestock.services.CommandeFournisseurService;
import com.fatma.gestiondestock.validator.CommandeFournisseurValidator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CommandeFournisseurServiceImpl implements CommandeFournisseurService {

	private CommandeFournisseurRepository commandeFournisseurRepository;
	private LigneCommandeFournisseurRepository ligneCommandeFournisseurRepository;

	public CommandeFournisseurServiceImpl(CommandeFournisseurRepository commandeFournisseurRepository,
			LigneCommandeFournisseurRepository ligneCommandeFournisseurRepository,
			ArticleRepository articleRepository) {
		this.commandeFournisseurRepository = commandeFournisseurRepository;
		this.ligneCommandeFournisseurRepository = ligneCommandeFournisseurRepository;
	}

	@Override
	public CommandeFournisseurDto save(CommandeFournisseurDto commandeFournisseurDto) {
		List<String> errors = CommandeFournisseurValidator.validate(commandeFournisseurDto);
		if (!errors.isEmpty()) {
			log.error("CommandeFournisseur not valide {}", commandeFournisseurDto);
			throw new InvalidEntityException("CommandeFournisseur n'est pas valid", ErrorCodes.ARTICLE_NOT_VALID,
					errors);
		}

		/*
		 * Optional<Fournisseur> client =
		 * clientRepository.findById(commandeFournisseurDto.getFournisseur().getId());
		 * if (!client.isPresent()) { log.warn("client with ID is not found"); throw new
		 * EntityNotFoundException("client with ID is not found "); } List<String>
		 * errorsAricle = new ArrayList<>(); if
		 * (!commandeFournisseurDto.getLigneCommandeFournisseurs().isEmpty()) {
		 * commandeFournisseurDto.getLigneCommandeFournisseurs().forEach(
		 * lignecommandeFournisseur ->{ if (lignecommandeFournisseur.getArticle()!=
		 * null) { Optional<Article> article =
		 * articleRepository.findById(lignecommandeFournisseur.getArticle().getId()); if
		 * (!article.isPresent()) {
		 * errorsAricle.add("l'article avec Id"+lignecommandeFournisseur.getArticle().
		 * getId() +"is not found"); }
		 * 
		 * } }); } if (!errorsAricle.isEmpty()) { log.warn("article not found "); throw
		 * new InvalidEntityException("article not found", ErrorCodes.ARTICLE_NOT_FOUND,
		 * errorsAriclegfn);
		 * 
		 * }
		 */

		CommandeFournisseur savedcommandeFournisseur = commandeFournisseurRepository
				.save(CommandeFournisseurDtoCommandeFournisseurMapper.INSTANCE
						.commandeFournisseurDtoToCommandeFournisseur(commandeFournisseurDto));
		CommandeFournisseurDto savedcommandeFournisseurDto = CommandeFournisseurDtoCommandeFournisseurMapper.INSTANCE
				.commandeFournisseurToCommandeFournisseurDto(savedcommandeFournisseur);
		if (!commandeFournisseurDto.getLigneCommandeFournisseurs().isEmpty()) {
			commandeFournisseurDto.getLigneCommandeFournisseurs().forEach(lignecommandeFournisseur -> {

				LigneCommandeFournisseur ligneCommandeFournisseursaved = LigneCommandeFournisseurDtoLigneCommandeFournisseurMapper.INSTANCE
						.lignecommandeFournisseurDtoToLigneCommandeFournisseur(lignecommandeFournisseur);
				ligneCommandeFournisseursaved.setCommandeFournisseur(savedcommandeFournisseur);
				ligneCommandeFournisseurRepository.save(ligneCommandeFournisseursaved);
			});

		}
		return savedcommandeFournisseurDto;

	}

	@Override
	public CommandeFournisseurDto findById(Integer id) {
		if (id == null) {
			log.error("CommandeFournisseur ID est null");
			return null;
		}
		Optional<CommandeFournisseur> commandeFournisseur = commandeFournisseurRepository.findById(id);
		return Optional
				.of(CommandeFournisseurDtoCommandeFournisseurMapper.INSTANCE
						.commandeFournisseurToCommandeFournisseurDto(commandeFournisseur.get()))
				.orElseThrow(() -> new EntityNotFoundException("id not found ", ErrorCodes.ARTICLE_NOT_FOUND));
	}

	@Override
	public List<CommandeFournisseurDto> findAll() {
		return commandeFournisseurRepository.findAll().stream().map(
				CommandeFournisseurDtoCommandeFournisseurMapper.INSTANCE::commandeFournisseurToCommandeFournisseurDto)
				.collect(Collectors.toList());
	}

	@Override
	public void delete(Integer id) {
		if (id == null) {
			log.error("CommandeFournisseur ID est null");
			return;

		}
		commandeFournisseurRepository.deleteById(id);

	}

}
