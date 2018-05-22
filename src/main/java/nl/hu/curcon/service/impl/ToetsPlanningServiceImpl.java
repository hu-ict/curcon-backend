package nl.hu.curcon.service.impl;

import java.util.ArrayList;
import java.util.List;

import nl.hu.curcon.dao.ToetsPlanningDao;
import nl.hu.curcon.domain.ToetsPlanning;
import nl.hu.curcon.dto.ToetsPlanningDto;
import nl.hu.curcon.dtomapper.Domain2DtoMapper;
import nl.hu.curcon.service.ToetsPlanningService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author berend.wilkens
 *
 */
@Service
public class ToetsPlanningServiceImpl extends GenericService implements ToetsPlanningService{
    @Autowired
    private ToetsPlanningDao toetsPlanningDao;

    @Override
    public ToetsPlanningDto create(ToetsPlanningDto toetsPlanningDto) {
    	ToetsPlanning toetsPlanning = dto2DomainMapper.map(toetsPlanningDto);
        return Domain2DtoMapper.map(toetsPlanningDao.save(toetsPlanning));
    }

    @Override
    public void delete(int id) {
    	toetsPlanningDao.delete(id);
    }

    @Override
    public ToetsPlanningDto update(ToetsPlanningDto toetsPlanningDto) {
    	ToetsPlanning toetsPlanning = dto2DomainMapper.map(toetsPlanningDto);
        return Domain2DtoMapper.map(toetsPlanningDao.update(toetsPlanning));
    }

	@Override
	public ToetsPlanningDto find(int id) {
        ToetsPlanning d = toetsPlanningDao.find(id);
        return Domain2DtoMapper.map(d);
	}

	@Override
    public List<ToetsPlanningDto> findAll() {
        List<ToetsPlanningDto> dtos = new ArrayList<ToetsPlanningDto>();
        List<ToetsPlanning> toetsPlanningen = toetsPlanningDao.findAll();
        for (ToetsPlanning d: toetsPlanningen){
            dtos.add(Domain2DtoMapper.map(d));
        }
        return dtos;
    }

}
