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
@EqualsAndHashCode(callSuper = true)
@Entity
@Table
public class LigneCommandeClient extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	@Column
	private BigDecimal quantite;

	@Column
	private BigDecimal prixUnitaire;

	@ManyToOne
	@JoinColumn(name = "id_article")
	private Article article;

	@ManyToOne
	@JoinColumn(name = "id_commandeclient")
	private CommandeClient commandeClient;

	@Column
	private Integer idEntreprise;
}
