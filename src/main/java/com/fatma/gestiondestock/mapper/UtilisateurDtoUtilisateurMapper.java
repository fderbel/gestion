package com.fatma.gestiondestock.mapper;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import com.fatma.gestiondestock.dto.UtilisateurDto;
import com.fatma.gestiondestock.model.Utilisateur;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, builder = @Builder(disableBuilder = true))
public interface UtilisateurDtoUtilisateurMapper {
	UtilisateurDtoUtilisateurMapper INSTANCE = Mappers.getMapper(UtilisateurDtoUtilisateurMapper.class);

	Utilisateur utilisateurDtoToUtilisateur(UtilisateurDto utilisateurDto);

	UtilisateurDto utilisateurToUtilisateurDto(Utilisateur utilisateur);

}
