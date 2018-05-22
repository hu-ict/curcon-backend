package nl.hu.curcon.service.impl;

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
	public FunctionDto find(String name) {
		Function function = funcDao.find(name);
		return Domain2DtoMapper.map(function);
	}
}
