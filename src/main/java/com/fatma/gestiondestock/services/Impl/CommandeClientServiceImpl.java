package com.fatma.gestiondestock.services.Impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.fatma.gestiondestock.dto.CommandeClientDto;
import com.fatma.gestiondestock.exception.EntityNotFoundException;
import com.fatma.gestiondestock.exception.ErrorCodes;
import com.fatma.gestiondestock.exception.InvalidEntityException;
import com.fatma.gestiondestock.mapper.CommandeClientDtoCommandeClientMapper;
import com.fatma.gestiondestock.mapper.LigneCommandeClientDtoLigneCommandeClientMapper;
import com.fatma.gestiondestock.model.CommandeClient;
import com.fatma.gestiondestock.model.LigneCommandeClient;
import com.fatma.gestiondestock.repository.ArticleRepository;
import com.fatma.gestiondestock.repository.CommandeClientRepository;
import com.fatma.gestiondestock.repository.LigneCommandeClientRepository;
import com.fatma.gestiondestock.services.CommandeClientService;
import com.fatma.gestiondestock.validator.CommandeClientValidator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CommandeClientServiceImpl implements CommandeClientService {

	private CommandeClientRepository commandeClientRepository;
	private LigneCommandeClientRepository ligneCommandeClientRepository;

	public CommandeClientServiceImpl(CommandeClientRepository commandeClientRepository,
			LigneCommandeClientRepository ligneCommandeClientRepository, ArticleRepository articleRepository) {
		this.commandeClientRepository = commandeClientRepository;
		this.ligneCommandeClientRepository = ligneCommandeClientRepository;
	}

	@Override
	public CommandeClientDto save(CommandeClientDto commandeClientDto) {
		List<String> errors = CommandeClientValidator.validate(commandeClientDto);
		if (!errors.isEmpty()) {
			log.error("CommandeClient not valide {}", commandeClientDto);
			throw new InvalidEntityException("CommandeClient n'est pas valid", ErrorCodes.ARTICLE_NOT_VALID, errors);
		}

		/*
		 * Optional<Client> client =
		 * clientRepository.findById(commandeClientDto.getClient().getId()); if
		 * (!client.isPresent()) { log.warn("client with ID is not found"); throw new
		 * EntityNotFoundException("client with ID is not found "); } List<String>
		 * errorsAricle = new ArrayList<>(); if
		 * (!commandeClientDto.getLigneCommandeClients().isEmpty()) {
		 * commandeClientDto.getLigneCommandeClients().forEach(lignecommandeClient ->{
		 * if (lignecommandeClient.getArticle()!= null) { Optional<Article> article =
		 * articleRepository.findById(lignecommandeClient.getArticle().getId()); if
		 * (!article.isPresent()) {
		 * errorsAricle.add("l'article avec Id"+lignecommandeClient.getArticle().getId()
		 * +"is not found"); }
		 * 
		 * } }); } if (!errorsAricle.isEmpty()) { log.warn("article not found "); throw
		 * new InvalidEntityException("article not found", ErrorCodes.ARTICLE_NOT_FOUND,
		 * errorsAriclegfn);
		 * 
		 * }
		 */

		CommandeClient savedcommandeClient = commandeClientRepository.save(
				CommandeClientDtoCommandeClientMapper.INSTANCE.commandeClientDtoToCommandeClient(commandeClientDto));
		CommandeClientDto savedcommandeClientDto = CommandeClientDtoCommandeClientMapper.INSTANCE
				.commandeClientToCommandeClientDto(savedcommandeClient);
		if (!commandeClientDto.getLigneCommandeClients().isEmpty()) {
			commandeClientDto.getLigneCommandeClients().forEach(lignecommandeClient -> {

				LigneCommandeClient ligneCommandeClientsaved = LigneCommandeClientDtoLigneCommandeClientMapper.INSTANCE
						.lignecommandeClientDtoToLigneCommandeClient(lignecommandeClient);
				ligneCommandeClientsaved.setCommandeClient(savedcommandeClient);
				ligneCommandeClientRepository.save(ligneCommandeClientsaved);
			});

		}
		return savedcommandeClientDto;

	}

	@Override
	public CommandeClientDto findById(Integer id) {
		if (id == null) {
			log.error("CommandeClient ID est null");
			return null;
		}
		Optional<CommandeClient> commandeClient = commandeClientRepository.findById(id);
		return Optional
				.of(CommandeClientDtoCommandeClientMapper.INSTANCE
						.commandeClientToCommandeClientDto(commandeClient.get()))
				.orElseThrow(() -> new EntityNotFoundException("id not found ", ErrorCodes.ARTICLE_NOT_FOUND));
	}

	@Override
	public List<CommandeClientDto> findAll() {
		return commandeClientRepository.findAll().stream()
				.map(CommandeClientDtoCommandeClientMapper.INSTANCE::commandeClientToCommandeClientDto)
				.collect(Collectors.toList());
	}

	@Override
	public void delete(Integer id) {
		if (id == null) {
			log.error("CommandeClient ID est null");
			return;

		}
		commandeClientRepository.deleteById(id);

	}

}
