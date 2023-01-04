package com.fatma.gestiondestock.validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.fatma.gestiondestock.dto.CommandeFournisseurDto;
import com.fatma.gestiondestock.model.Article;
import com.fatma.gestiondestock.model.Fournisseur;
import com.fatma.gestiondestock.repository.ArticleRepository;
import com.fatma.gestiondestock.repository.FournisseurRepository;

public class CommandeFournisseurValidator {

	@Autowired
	private static FournisseurRepository clientRepository;

	@Autowired
	private static ArticleRepository articleRepository;

	public static List<String> validate(CommandeFournisseurDto commandeFournisseurDto) {
		List<String> errors = new ArrayList<String>();
		if (commandeFournisseurDto == null) {
			errors.add("article is null ");
			return errors;
		}
		if (!StringUtils.hasLength(commandeFournisseurDto.getCode())) {
			errors.add("Veillez renseigner le code de la commande client  ");
		}

		// Verif Fournisseur Existe

		Optional<Fournisseur> client = clientRepository.findById(commandeFournisseurDto.getFournisseur().getId());
		if (!client.isPresent()) {
			errors.add("client with ID is not found ");
		}

		// Verif Ligne CommandeFournisseur Existe

		if (!commandeFournisseurDto.getLigneCommandeFournisseurs().isEmpty()) {
			commandeFournisseurDto.getLigneCommandeFournisseurs().forEach(lignecommandeFournisseur -> {
				if (lignecommandeFournisseur.getArticle() != null) {
					Optional<Article> article = articleRepository
							.findById(lignecommandeFournisseur.getArticle().getId());
					if (!article.isPresent()) {
						errors.add(
								"l'article avec Id" + lignecommandeFournisseur.getArticle().getId() + "is not found");
					}

				}
			});
		}

		return errors;
	}
}
