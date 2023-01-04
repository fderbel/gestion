package com.fatma.gestiondestock.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.fatma.gestiondestock.dto.AdressDto;
import com.fatma.gestiondestock.model.Adress;

public class AdressDtoAdressMapperTest {

	@Test
	public void givenAdressDtoToAdress_whenMaps_thenCorrect() {
		AdressDto simpleAdressDto = new AdressDto();
		simpleAdressDto.setVille("ville");
		Adress Adress = AdressDtoAdressMapper.INSTANCE.adressDtoToAdress(simpleAdressDto);

		assertEquals(simpleAdressDto.getVille(), Adress.getVille());

	}

	@Test
	public void givenAdressToAdressDto_whenMaps_thenCorrect() {
		Adress Adress = new Adress();
		Adress.setVille("ville");

		AdressDto AdressDto = AdressDtoAdressMapper.INSTANCE.adressToAdressDto(Adress);
		assertEquals(Adress.getVille(), AdressDto.getVille());

	}
}
