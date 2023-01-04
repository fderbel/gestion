package com.fatma.gestiondestock.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable


public class Adress {

	@Column
	private String adress1 ;
	@Column
	private String adress2 ;
	@Column
	private String ville ;
	
	@Column
	private String codePostal ;
	
	@Column
	private String pays ;
}
