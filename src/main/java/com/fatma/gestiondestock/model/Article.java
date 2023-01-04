package com.fatma.gestiondestock.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;



@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=true)
@Entity
@Table
public class Article  extends AbstractEntity{

	private static final long serialVersionUID = 914861596632325654L;

	@Column
	private String code ;
	
	@Column
	private String designation;
	
	@Column
	private BigDecimal prixUnitaireHt;
	
	@Column
	private BigDecimal prixUnitairettc;
	
	@Column
	private BigDecimal tauxTva;
	
	@Column
	private String photo;
	
	@ManyToOne 
	@JoinColumn (name = "id_category")
	private Category category;
	
	@Column 
	private Integer idEntreprise ;
}
