package com.fatma.gestiondestock.exception;

public enum ErrorCodes {
ARTICLE_NOT_FOUND (1000),
ARTICLE_NOT_VALID (1001),
CATEGORY_NOT_FOUND (2000),
CLIENT_NOT_FOUND (3000),
UTILISATEUR_NOT_FOUND (4000),
FOURNISSEUR_NOT_FOUND (5000),
LIGNE_COMMANDE_CLIENT_NOT_FOUND (6000),
LIGNE_COMMANDE_FORUNISSEUR_NOT_FOUND (7000),
LIGNE_VENTE_NOT_FOUND (8000),
MVT_STOCK_NOT_FOUND (9000),
ROLES_FOUND (10000),
VENTES_NOT_FOUND (11000),
;
	
	private int code ; 
	ErrorCodes (int code){
		this.code = code;
	}
	public int getCode() {
		return code ;
	}
}
