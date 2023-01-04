package com.fatma.gestiondestock.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LigneCommandeClientDto {

	private Integer id;
	private BigDecimal quantite;
	private BigDecimal prixUnitaire;
	private ArticleDto article;
	private CommandeClientDto commandeClient;

}
