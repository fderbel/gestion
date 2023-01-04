package com.fatma.gestiondestock.validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.fatma.gestiondestock.dto.VentesDto;
import com.fatma.gestiondestock.model.Article;
import com.fatma.gestiondestock.repository.ArticleRepository;

public class VentesValidator {

	@Autowired
	private static ArticleRepository articleRepository;

	public static List<String> validate(VentesDto ventesDto) {
		List<String> errors = new ArrayList<String>();
		if (ventesDto == null) {
			errors.add("article is null ");
			return errors;
		}
		if (!StringUtils.hasLength(ventesDto.getCode())) {
			errors.add("Veillez renseigner le code de la commande client  ");
		}

		if (!ventesDto.getLigneVentes().isEmpty()) {
			errors.add("Veillez renseigner les ligne de ventes  ");
		}
		// Verif Ligne Ventes Existe

		ventesDto.getLigneVentes().forEach(ligneventes -> {
			if (ligneventes.getArticle() != null) {
				Optional<Article> article = articleRepository.findById(ligneventes.getArticle().getId());
				if (!article.isPresent()) {
					errors.add("l'article avec Id" + ligneventes.getArticle().getId() + "is not found");
				}

			}
		});

		return errors;
	}
}
