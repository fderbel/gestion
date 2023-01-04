package com.fatma.gestiondestock.mapper;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.fatma.gestiondestock.dto.AdressDto;
import com.fatma.gestiondestock.model.Adress;

@Mapper(builder = @Builder(disableBuilder = true))
public interface AdressDtoAdressMapper {
	AdressDtoAdressMapper INSTANCE = Mappers.getMapper(AdressDtoAdressMapper.class);

	Adress adressDtoToAdress(AdressDto adressDto);

	AdressDto adressToAdressDto(Adress adress);

}
