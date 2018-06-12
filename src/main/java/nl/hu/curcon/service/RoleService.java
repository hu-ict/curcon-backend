package nl.hu.curcon.service;

import java.util.List;

import nl.hu.curcon.dto.ModuleDto;
import nl.hu.curcon.dto.RoleDto;

public interface RoleService {

	RoleDto find(int id);

	List<ModuleDto> findModulesByRoleId(int id);

	List<RoleDto> findAll();

}
