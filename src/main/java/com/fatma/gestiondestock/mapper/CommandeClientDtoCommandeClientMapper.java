package com.fatma.gestiondestock.mapper;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.fatma.gestiondestock.dto.CommandeClientDto;
import com.fatma.gestiondestock.model.CommandeClient;

@Mapper(builder = @Builder(disableBuilder = true))
public interface CommandeClientDtoCommandeClientMapper {
	CommandeClientDtoCommandeClientMapper INSTANCE = Mappers.getMapper(CommandeClientDtoCommandeClientMapper.class);

	CommandeClient commandeClientDtoToCommandeClient(CommandeClientDto commandeClientDto);

	// @Mapping(target = "ligneCommandeClients", ignore = true)

	CommandeClientDto commandeClientToCommandeClientDto(CommandeClient commandeClient);

}
