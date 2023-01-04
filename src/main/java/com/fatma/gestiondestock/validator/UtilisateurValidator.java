package com.fatma.gestiondestock.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.fatma.gestiondestock.dto.UtilisateurDto;

public class UtilisateurValidator {

	public static List<String> validate (  UtilisateurDto utilisateurDto){
		List<String> errors = new ArrayList<String>();
		if (utilisateurDto == null) {
			errors.add("name user is undefined ");
			errors.add("first name user is undefined ");
			errors.add("password user is undefined ");
			errors.add("adress user is undefined ");
			return errors;
		}
		if (!StringUtils.hasLength(utilisateurDto.getNom())) {
			errors.add("name user is undefined ");
		}
		
		if (!StringUtils.hasLength(utilisateurDto.getPrenom())) {
			errors.add("first name user is undefined ");
		}
		
		if (!StringUtils.hasLength(utilisateurDto.getEmail())) {
			errors.add("email user is undefined ");
		}
		
		return errors;
	}
}
