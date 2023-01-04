package com.fatma.gestiondestock.mapper;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import com.fatma.gestiondestock.dto.FournisseurDto;
import com.fatma.gestiondestock.model.Fournisseur;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, builder = @Builder(disableBuilder = true))
public interface FournisseurDtoFournisseurMapper {
	FournisseurDtoFournisseurMapper INSTANCE = Mappers.getMapper(FournisseurDtoFournisseurMapper.class);

	Fournisseur fournisseurDtoToFournisseur(FournisseurDto fournisseurDto);

	FournisseurDto fournisseurToFournisseurDto(Fournisseur fournisseur);

}
