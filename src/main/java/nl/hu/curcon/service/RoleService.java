package nl.hu.curcon.service;

import java.util.List;

import nl.hu.curcon.dto.ModuleDto;
import nl.hu.curcon.dto.RoleDto;
import nl.hu.curcon.dto.post.ModulePostDto;
import nl.hu.curcon.dto.post.RolePutDto;

public interface RoleService {

	RoleDto find(int id);

	List<ModuleDto> findModulesByRoleId(int id);

	List<RoleDto> findAll();

	boolean update(int id, RolePutDto roleDto);

	boolean delete(int id);

	int create(RolePutDto roleDto);

	boolean addModuleToRole(int roleId, int moduleId);

	boolean removeModuleFromRole(int roleId, int moduleId);

}
