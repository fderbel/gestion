package com.fatma.gestiondestock.mapper;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.fatma.gestiondestock.dto.ClientDto;
import com.fatma.gestiondestock.model.Client;

@Mapper(builder = @Builder(disableBuilder = true))
public interface ClientDtoClientMapper {
	ClientDtoClientMapper INSTANCE = Mappers.getMapper(ClientDtoClientMapper.class);

	Client clientDtoToClient(ClientDto clientDto);

	ClientDto clientToClientDto(Client client);

}
