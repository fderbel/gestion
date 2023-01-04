package com.fatma.gestiondestock.mapper;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.fatma.gestiondestock.dto.LigneCommandeClientDto;
import com.fatma.gestiondestock.model.LigneCommandeClient;

@Mapper(builder = @Builder(disableBuilder = true))
public interface LigneCommandeClientDtoLigneCommandeClientMapper {
	LigneCommandeClientDtoLigneCommandeClientMapper INSTANCE = Mappers
			.getMapper(LigneCommandeClientDtoLigneCommandeClientMapper.class);

	LigneCommandeClient lignecommandeClientDtoToLigneCommandeClient(LigneCommandeClientDto lignecommandeClientDto);

	LigneCommandeClientDto lignecommandeClientToLigneCommandeClientDto(LigneCommandeClient lignecommandeClient);

}
