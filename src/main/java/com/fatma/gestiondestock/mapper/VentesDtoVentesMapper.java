package com.fatma.gestiondestock.mapper;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.fatma.gestiondestock.dto.VentesDto;
import com.fatma.gestiondestock.model.Ventes;

@Mapper(builder = @Builder(disableBuilder = true))
public interface VentesDtoVentesMapper {
	VentesDtoVentesMapper INSTANCE = Mappers.getMapper(VentesDtoVentesMapper.class);

	Ventes ventesDtoToVentes(VentesDto ventesDto);

	VentesDto ventesToVentesDto(Ventes ventes);

}
