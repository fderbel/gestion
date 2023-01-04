package com.fatma.gestiondestock.handlers;

import java.util.List;

import com.fatma.gestiondestock.exception.ErrorCodes;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ErrorDto {

	private Integer httpCode;
	
	private ErrorCodes code;
	
	private String message ; 
	
	private List <String> errors ;
}
