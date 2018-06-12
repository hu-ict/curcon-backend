package nl.hu.curcon.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.hu.curcon.dao.FunctionDao;
import nl.hu.curcon.domain.Function;
import nl.hu.curcon.dto.FunctionDto;
import nl.hu.curcon.dtomapper.Domain2DtoMapper;
import nl.hu.curcon.service.FunctionService;

@Service
public class FunctionServiceImpl extends GenericService implements FunctionService {
	@Autowired
	private FunctionDao funcDao;

	@Override
	public FunctionDto find(int id) {
		Function function = funcDao.find(id);
		return Domain2DtoMapper.map(function);
	}

	@Override
	public List<FunctionDto> findAll() {
		List<FunctionDto> dtos = new ArrayList<FunctionDto>();
		List<Function> functies = funcDao.findAll();
		for (Function f : functies) {
			dtos.add(Domain2DtoMapper.map(f));
		}
		return dtos;
	}

}
