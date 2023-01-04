package com.fatma.gestiondestock.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LigneCommandeFournisseurDto {

	private Integer id ; 
	private ArticleDto article ;
	private CommandeClientDto commandeFournisseur;
}
