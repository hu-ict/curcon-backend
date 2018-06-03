package nl.hu.curcon.service;

import java.util.List;

import nl.hu.curcon.dto.FunctionDto;
import nl.hu.curcon.dto.ModuleDto;

public interface ModuleService {

	ModuleDto find(int id);

	List<FunctionDto> findFunctionsByModuleId(int id);
	
	

}
