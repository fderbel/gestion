package com.fatma.gestiondestock.model;

import java.time.Instant;
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
@EqualsAndHashCode(callSuper = true)
@Entity
@Table

public class Ventes extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	@Column
	private String code;

	@Column
	private String commentaire;

	@Column
	private Instant date;

	@Column
	private Integer idEntreprise;

	@OneToMany(mappedBy = "vente")
	private List<LigneVente> ligneVentes;
}
