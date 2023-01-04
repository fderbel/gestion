package com.fatma.gestiondestock.validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.fatma.gestiondestock.dto.CommandeClientDto;
import com.fatma.gestiondestock.model.Article;
import com.fatma.gestiondestock.model.Client;
import com.fatma.gestiondestock.repository.ArticleRepository;
import com.fatma.gestiondestock.repository.ClientRepository;

public class CommandeClientValidator {

	@Autowired
	private static ClientRepository clientRepository;

	@Autowired
	private static ArticleRepository articleRepository;

	public static List<String> validate(CommandeClientDto commandeClientDto) {
		List<String> errors = new ArrayList<String>();
		if (commandeClientDto == null) {
			errors.add("article is null ");
			return errors;
		}
		if (!StringUtils.hasLength(commandeClientDto.getCode())) {
			errors.add("Veillez renseigner le code de la commande client  ");
		}

		// Verif Client Existe

		Optional<Client> client = clientRepository.findById(commandeClientDto.getClient().getId());
		if (!client.isPresent()) {
			errors.add("client with ID is not found ");
		}

		// Verif Ligne CommandeClient Existe

		if (!commandeClientDto.getLigneCommandeClients().isEmpty()) {
			commandeClientDto.getLigneCommandeClients().forEach(lignecommandeClient -> {
				if (lignecommandeClient.getArticle() != null) {
					Optional<Article> article = articleRepository.findById(lignecommandeClient.getArticle().getId());
					if (!article.isPresent()) {
						errors.add("l'article avec Id" + lignecommandeClient.getArticle().getId() + "is not found");
					}

				}
			});
		}

		return errors;
	}
}
