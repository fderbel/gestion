package com.fatma.gestiondestock.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
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
public class Client extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	
	@Column
	private String nom ;
	
	@Column
	private String prenom ;
	
	@Column
	private String code ;
	
	@Column
	private String photo;
	
	@Column
	private String email ;
	
	@Column
	private String numTel ;
	
	@Embedded
	private Adress adress ; 
	
	@Column 
	private Integer idEntreprise ;
	
	@OneToMany (mappedBy = "client")
	private List <CommandeClient> commandeClients;
}
