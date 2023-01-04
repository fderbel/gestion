package com.fatma.gestiondestock.mapper;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.fatma.gestiondestock.dto.LigneVenteDto;
import com.fatma.gestiondestock.model.LigneVente;

@Mapper(builder = @Builder(disableBuilder = true))
public interface LigneVenteDtoLigneVenteMapper {
	LigneVenteDtoLigneVenteMapper INSTANCE = Mappers.getMapper(LigneVenteDtoLigneVenteMapper.class);

	LigneVente ligneVenteDtoToLigneVente(LigneVenteDto ligneVenteDto);

	LigneVenteDto ligneVenteToLigneVenteDto(LigneVente ligneVente);

}
