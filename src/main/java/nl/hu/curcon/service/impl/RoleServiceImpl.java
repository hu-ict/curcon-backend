package nl.hu.curcon.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nl.hu.curcon.dao.ModuleDao;
import nl.hu.curcon.dao.RoleDao;
import nl.hu.curcon.domain.Cursus;
import nl.hu.curcon.domain.Docent;
import nl.hu.curcon.domain.Module;
import nl.hu.curcon.domain.OpleidingsProfiel;
import nl.hu.curcon.domain.Organisatie;
import nl.hu.curcon.domain.Role;
import nl.hu.curcon.domain.User;
import nl.hu.curcon.dto.ModuleDto;
import nl.hu.curcon.dto.OpleidingsProfielDto;
import nl.hu.curcon.dto.RoleDto;
import nl.hu.curcon.dto.UserDto;
import nl.hu.curcon.dto.post.ModulePostDto;
import nl.hu.curcon.dto.post.RolePutDto;
import nl.hu.curcon.dtomapper.Domain2DtoMapper;
import nl.hu.curcon.service.RoleService;

@Service
public class RoleServiceImpl extends GenericService implements RoleService {
	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private ModuleDao moduleDao;

	@Transactional
	@Override
	public RoleDto find(int id) {
		Role Role = roleDao.find(id);
		return Domain2DtoMapper.map(Role);
	}

	@Transactional
	@Override
	public List<ModuleDto> findModulesByRoleId(int id) {
		Role Role = roleDao.find(id);
		if (Role == null)
			return null;
		List<ModuleDto> modules = new ArrayList<>();
		for (Module module : Role.getModules()) {
			modules.add(Domain2DtoMapper.map(module));
		}
		return modules;
	}

	@Override
	public List<RoleDto> findAll() {
		List<RoleDto> dtos = new ArrayList<RoleDto>();
		List<Role> roles = roleDao.findAll();
		for (Role r : roles) {
			dtos.add(Domain2DtoMapper.map(r));
		}
		return dtos;
	}
	@Override
	@Transactional
	public int create(RolePutDto roleDto) {
		Role role = dto2DomainMapper.map(roleDto);
		role = roleDao.save(role);
		return role.getId();
	}
	
	@Override
	@Transactional
	public boolean delete(int id) {
		Role role = roleDao.find(id);
		if (role == null) { return false; }
		roleDao.delete(id);
		return true;
	}

	@Override
	@Transactional
	public boolean update(int id, RolePutDto roleDto) {
		Role role = roleDao.find(id);
		if (role == null) { return false; }
		role.setName(roleDto.getName());
		role = roleDao.update(role);
		return true;
	}

	@Override
	@Transactional
	public boolean addModuleToRole(int roleId, int moduleId) {
		Role role = roleDao.find(roleId);
		if (role == null) {return false;};
		Module module=moduleDao.find(moduleId);
		if (module==null) {
		return false;
		}
		role.getModules().add(module);
		roleDao.save(role);
		return true;
	}

}
