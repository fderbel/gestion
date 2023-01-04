package com.fatma.gestiondestock.services;

import java.util.List;

import com.fatma.gestiondestock.dto.VentesDto;

public interface VentesService {

	VentesDto save(VentesDto ventesDto);

	VentesDto findById(Integer id);

	List<VentesDto> findAll();

	void delete(Integer id);
}
