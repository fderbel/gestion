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
public class LigneVenteDto {

	private Integer id;
	private VentesDto vente;
	private BigDecimal quantites;
	private ArticleDto article;
}
