package nl.hu.curcon.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nl.hu.curcon.dao.FunctionDao;
import nl.hu.curcon.domain.Function;
import nl.hu.curcon.domain.Function;
import nl.hu.curcon.dto.FunctionDto;
import nl.hu.curcon.dto.post.FunctionPostDto;
import nl.hu.curcon.dto.FunctionDto;
import nl.hu.curcon.dtomapper.Domain2DtoMapper;
import nl.hu.curcon.service.FunctionService;

@Service
public class FunctionServiceImpl extends GenericService implements FunctionService {
	@Autowired
	private FunctionDao functionDao;

	@Override
	public FunctionDto find(int id) {
		Function function = functionDao.find(id);
		return Domain2DtoMapper.map(function);
	}

	@Override
	public List<FunctionDto> findAll() {
		List<FunctionDto> dtos = new ArrayList<FunctionDto>();
		List<Function> functies = functionDao.findAll();
		for (Function f : functies) {
			dtos.add(Domain2DtoMapper.map(f));
		}
		return dtos;
	}
	@Override
	@Transactional
	public int create(FunctionPostDto functionDto) {
		Function function = dto2DomainMapper.map(functionDto);
		function = functionDao.save(function);
		return function.getId();
	}
	
	@Override
	@Transactional
	public boolean delete(int id) {
		Function function = functionDao.find(id);
		if (function == null) { return false; }
		functionDao.delete(id);
		return true;
	}

	@Override
	@Transactional
	public boolean update(int id, FunctionPostDto FunctionDto) {
		Function function = functionDao.find(id);
		if (function == null) { return false; }
		function.setName(FunctionDto.getName());
		function = functionDao.update(function);
		return true;
	}

}
