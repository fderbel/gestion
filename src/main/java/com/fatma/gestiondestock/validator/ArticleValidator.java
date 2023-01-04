package com.fatma.gestiondestock.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.fatma.gestiondestock.dto.ArticleDto;

public class ArticleValidator {

	public static List<String> validate (  ArticleDto articleDto){
		List<String> errors = new ArrayList<String>();
		if (articleDto == null) {
			errors.add("article is null ");
			return errors;
		}
		if (!StringUtils.hasLength(articleDto.getCode())) {
			errors.add("Veillez renseigner le code de l'article  ");
		}
		
		if (!StringUtils.hasLength(articleDto.getDesignation())) {
			errors.add("Veillez renseigner la désignation de l'article  ");

		}
		
		if (articleDto.getPrixUnitaireHt()== null) {
			errors.add("Veillez renseigner leprix unitaire de l'article  ");

		}
		
		if (articleDto.getTauxTva()== null) {
			errors.add("Veillez renseigner leprix unitaire de l'article  ");
		}
		
		return errors;
	}
}
