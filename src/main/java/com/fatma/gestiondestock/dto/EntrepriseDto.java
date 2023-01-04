package com.fatma.gestiondestock.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EntrepriseDto {

	private Integer id ; 
	private String nom;
	private String code;
}
