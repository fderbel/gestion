package com.fatma.gestiondestock.mapper;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import com.fatma.gestiondestock.dto.EntrepriseDto;
import com.fatma.gestiondestock.model.Entreprise;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, builder = @Builder(disableBuilder = true))
public interface EntrepriseDtoEntrepriseMapper {
	EntrepriseDtoEntrepriseMapper INSTANCE = Mappers.getMapper(EntrepriseDtoEntrepriseMapper.class);

	Entreprise entrepriseDtoToEntreprise(EntrepriseDto entrepriseDto);

	EntrepriseDto entrepriseToEntrepriseDto(Entreprise entreprise);

}
