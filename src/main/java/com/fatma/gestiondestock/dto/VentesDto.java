package com.fatma.gestiondestock.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class VentesDto {
	private Integer id;
	private String code;
	private List<LigneVenteDto> ligneVentes;
}
