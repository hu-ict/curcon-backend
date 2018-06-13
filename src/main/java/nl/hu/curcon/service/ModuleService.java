package nl.hu.curcon.service;

import java.util.List;

import nl.hu.curcon.dto.FunctionDto;
import nl.hu.curcon.dto.ModuleDto;
import nl.hu.curcon.dto.post.FunctionPostDto;
import nl.hu.curcon.dto.post.ModulePostDto;

public interface ModuleService {

	ModuleDto find(int id);

	List<FunctionDto> findFunctionsByModuleId(int id);
	List <ModuleDto> findAll();

	int create(ModulePostDto moduleDto);

	boolean delete(int id);

	boolean update(int id, ModulePostDto moduleDto);

	boolean addFunctionToModule(int moduleId, int functionId);
	

}
