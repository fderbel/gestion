package com.fatma.gestiondestock.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RolesDto {

	private Integer id ; 
	private String nom ;
}
