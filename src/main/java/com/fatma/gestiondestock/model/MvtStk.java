
package com.fatma.gestiondestock.model;

import java.math.BigDecimal;
import java.time.Instant;

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
public class MvtStk extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	@Column
	private Instant dateMvt;

	@Column
	private BigDecimal quantite;

	@Column
	private int typeMvt;

	@Column
	private Integer idEntreprise;

	@ManyToOne
	@JoinColumn(name = "id_article")
	private Article article;
}
