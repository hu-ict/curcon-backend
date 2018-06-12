package nl.hu.curcon.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nl.hu.curcon.dao.RoleDao;
import nl.hu.curcon.domain.Module;
import nl.hu.curcon.domain.OpleidingsProfiel;
import nl.hu.curcon.domain.Organisatie;
import nl.hu.curcon.domain.Role;
import nl.hu.curcon.dto.ModuleDto;
import nl.hu.curcon.dto.OpleidingsProfielDto;
import nl.hu.curcon.dto.RoleDto;
import nl.hu.curcon.dtomapper.Domain2DtoMapper;
import nl.hu.curcon.service.RoleService;

@Service
public class RoleServiceImpl extends GenericService implements RoleService {
	@Autowired
	private RoleDao roleDao; 
	
	@Transactional
	@Override
	public RoleDto find(int id) {
		Role Role = roleDao.find(id);
		return Domain2DtoMapper.map(Role);
	}

	@Transactional
	@Override
	public List<ModuleDto>findModulesByRoleId(int id){
		Role Role = roleDao.find(id);
		if (Role == null)
			return null;
		List<ModuleDto> modules =new ArrayList<>();
		for (Module module : Role.getModules()) {
			modules.add(Domain2DtoMapper.map(module));
		}
        return modules;
	}
}
