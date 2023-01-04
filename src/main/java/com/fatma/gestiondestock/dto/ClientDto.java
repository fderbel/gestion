package com.fatma.gestiondestock.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientDto {

	private Integer id;
	private String nom;
	private String prenom;
	private String code;
	private String photo;
	private String email;
	private String numTel;
	private AdressDto adress;
	// private List <CommandeClientDto> commandeClients;
}
