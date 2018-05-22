package nl.hu.curcon.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.hu.curcon.dao.RoleDao;
import nl.hu.curcon.domain.Role;
import nl.hu.curcon.dto.RoleDto;
import nl.hu.curcon.dtomapper.Domain2DtoMapper;
import nl.hu.curcon.service.RoleService;

@Service
public class RoleServiceImpl extends GenericService implements RoleService {
	@Autowired
	private RoleDao funcDao; 
	
	@Override
	public RoleDto find(String name) {
		Role Role = funcDao.find(name);
		return Domain2DtoMapper.map(Role);
	}
}
