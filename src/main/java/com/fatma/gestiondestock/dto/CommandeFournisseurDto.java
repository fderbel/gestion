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

public class CommandeFournisseurDto {

	private Integer id;
	private String code;
	private Instant dateCommande;
	private FournisseurDto fournisseur;
	private List<LigneCommandeFournisseurDto> ligneCommandeFournisseurs;

}
