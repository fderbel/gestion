package com.fatma.gestiondestock.dto;

import java.time.Instant;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommandeClientDto {

	private Integer id;
	private String code;
	private Instant dateCommande;
	private ClientDto client;
	private List<LigneCommandeClientDto> ligneCommandeClients;
}
