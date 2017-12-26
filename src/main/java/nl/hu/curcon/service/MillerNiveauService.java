package nl.hu.curcon.service;

import java.util.List;

import nl.hu.curcon.dto.MillerNiveauDto;

public interface MillerNiveauService {

	MillerNiveauDto find(int id);

	List<MillerNiveauDto> findAll();

}
