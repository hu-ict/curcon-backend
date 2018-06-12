package nl.hu.curcon.service;

import java.util.List;

import nl.hu.curcon.dto.FunctionDto;

public interface FunctionService {

	FunctionDto find(int id);
	List <FunctionDto> findAll();
}
