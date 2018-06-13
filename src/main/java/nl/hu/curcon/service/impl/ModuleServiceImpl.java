package nl.hu.curcon.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nl.hu.curcon.dao.FunctionDao;
import nl.hu.curcon.dao.ModuleDao;
import nl.hu.curcon.domain.Function;
import nl.hu.curcon.domain.Module;
import nl.hu.curcon.domain.Role;
import nl.hu.curcon.domain.Module;
import nl.hu.curcon.dto.FunctionDto;
import nl.hu.curcon.dto.ModuleDto;
import nl.hu.curcon.dto.post.FunctionPostDto;
import nl.hu.curcon.dto.post.ModulePostDto;
import nl.hu.curcon.dto.ModuleDto;
import nl.hu.curcon.dtomapper.Domain2DtoMapper;
import nl.hu.curcon.service.ModuleService;

@Service
public class ModuleServiceImpl extends GenericService implements ModuleService {
	@Autowired
	private ModuleDao moduleDao;
	
	@Autowired
	private FunctionDao functionDao;

	@Override
	public ModuleDto find(int id) {
		return Domain2DtoMapper.map(moduleDao.find(id));
	}

	@Transactional
	@Override
	public List<FunctionDto> findFunctionsByModuleId(int id) {
	    Module module = moduleDao.find(id);
		if (module == null)
			return null;
		List<FunctionDto> functions = new ArrayList<>();
		for (Function f : module.getFunctions()) {
			functions.add(Domain2DtoMapper.map(f));
		}
		return functions;
	}
	@Override
	public List<ModuleDto> findAll() {
		List<ModuleDto> dtos = new ArrayList<ModuleDto>();
		List<Module> modules = moduleDao.findAll();
		for (Module m : modules) {
			dtos.add(Domain2DtoMapper.map(m));
		}
		return dtos;
	}
	@Override
	@Transactional
	public int create(ModulePostDto moduleDto) {
		Module module = dto2DomainMapper.map(moduleDto);
		module = moduleDao.save(module);
		return module.getId();
	}
	
	@Override
	@Transactional
	public boolean delete(int id) {
		Module module = moduleDao.find(id);
		if (module == null) { return false; }
		moduleDao.delete(id);
		return true;
	}

	@Override
	@Transactional
	public boolean update(int id, ModulePostDto moduleDto) {
		Module module = moduleDao.find(id);
		if (module == null) { return false; }
		module.setName(moduleDto.getName());
		module = moduleDao.update(module);
		return true;
	}
	@Override
	@Transactional
	public boolean addFunctionToModule(int moduleId, int functionId) {
		Module module = moduleDao.find(moduleId);
		if (module == null) return false;
		Function function = functionDao.find(functionId);
	    if (function==null){
	    	return false;
	    }
		module.getFunctions().add(function);
		moduleDao.save(module);
		return true;
	}
}
