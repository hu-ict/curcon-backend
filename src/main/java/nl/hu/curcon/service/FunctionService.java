package nl.hu.curcon.service;

import java.util.List;

import nl.hu.curcon.dto.FunctionDto;
import nl.hu.curcon.dto.post.FunctionPostDto;

public interface FunctionService {

	FunctionDto find(int id);
	List <FunctionDto> findAll();
	boolean delete(int id);
	int create(FunctionPostDto functionDto);
	boolean update(int id, FunctionPostDto functionDto);
}
