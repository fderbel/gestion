package com.fatma.gestiondestock.mapper;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import com.fatma.gestiondestock.dto.LigneCommandeFournisseurDto;
import com.fatma.gestiondestock.model.LigneCommandeFournisseur;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, builder = @Builder(disableBuilder = true))
public interface LigneCommandeFournisseurDtoLigneCommandeFournisseurMapper {
	LigneCommandeFournisseurDtoLigneCommandeFournisseurMapper INSTANCE = Mappers
			.getMapper(LigneCommandeFournisseurDtoLigneCommandeFournisseurMapper.class);

	// @Mapping(target = "ligneCommandeFournisseurs", ignore = true)
	LigneCommandeFournisseur lignecommandeFournisseurDtoToLigneCommandeFournisseur(
			LigneCommandeFournisseurDto lignecommandeFournisseurDto);

	// @Mapping(target = "ligneCommandeFournisseurs", ignore = true)
	LigneCommandeFournisseurDto lignecommandeFournisseurToLigneCommandeFournisseurDto(
			LigneCommandeFournisseur lignecommandeFournisseur);

}
