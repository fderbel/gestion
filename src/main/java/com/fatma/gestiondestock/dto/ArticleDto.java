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
public class ArticleDto {
	private Integer id;
	private String code;
	private String designation;
	private BigDecimal prixUnitaireHt;
	private BigDecimal prixUnitairettc;
	private BigDecimal tauxTva;
	private String photo;
	private CategoryDto category;
	private Integer idEntreprise;

}
