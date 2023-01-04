package com.fatma.gestiondestock.mapper;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import com.fatma.gestiondestock.dto.CommandeFournisseurDto;
import com.fatma.gestiondestock.model.CommandeFournisseur;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, builder = @Builder(disableBuilder = true))
public interface CommandeFournisseurDtoCommandeFournisseurMapper {
	CommandeFournisseurDtoCommandeFournisseurMapper INSTANCE = Mappers
			.getMapper(CommandeFournisseurDtoCommandeFournisseurMapper.class);

	// @Mapping(target = "ligneCommandeFournisseurs", ignore = true)
	CommandeFournisseur commandeFournisseurDtoToCommandeFournisseur(CommandeFournisseurDto commandeFournisseurDto);

	// @Mapping(target = "ligneCommandeFournisseurs", ignore = true)
	CommandeFournisseurDto commandeFournisseurToCommandeFournisseurDto(CommandeFournisseur commandeFournisseur);

}
