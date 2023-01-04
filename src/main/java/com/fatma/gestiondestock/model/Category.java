package com.fatma.gestiondestock.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
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

public class Category  extends AbstractEntity {

	private static final long serialVersionUID = -8688385320689064716L;

	@Column
	private String code; 
	
	@Column
	private String designation;
	
	@Column 
	private Integer idEntreprise ;
	
	@OneToMany(mappedBy = "category")
	private List<Article> articles;
}
