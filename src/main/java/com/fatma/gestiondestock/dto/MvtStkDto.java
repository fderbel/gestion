
package com.fatma.gestiondestock.dto;

import java.math.BigDecimal;
import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MvtStkDto {

	private Integer id;
	private Instant dateMvt;

	private BigDecimal quantite;

	private int typeMvt;
	private ArticleDto article;
}
