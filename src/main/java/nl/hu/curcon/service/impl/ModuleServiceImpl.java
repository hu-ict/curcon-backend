package nl.hu.curcon.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.hu.curcon.dao.ModuleDao;
import nl.hu.curcon.domain.Module;
import nl.hu.curcon.dto.ModuleDto;
import nl.hu.curcon.dtomapper.Domain2DtoMapper;
import nl.hu.curcon.service.ModuleService;

@Service
public class ModuleServiceImpl extends GenericService implements ModuleService {
	@Autowired
	private ModuleDao funcDao; 
	
	@Override
	public ModuleDto find(String name) {
		Module Module = funcDao.find(name);
		return Domain2DtoMapper.map(Module);
	}
}
