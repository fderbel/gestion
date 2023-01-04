package com.fatma.gestiondestock.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class AdressDto {

	private String adress1 ;
	private String adress2 ;
	private String ville ;
	private String codePostal ;
	private String pays ;
}
