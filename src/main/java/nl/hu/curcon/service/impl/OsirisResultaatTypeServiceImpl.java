package nl.hu.curcon.service.impl;

import java.util.ArrayList;
import java.util.List;

import nl.hu.curcon.dao.OsirisResultaatTypeDao;
import nl.hu.curcon.domain.OsirisResultaatType;
import nl.hu.curcon.dto.OsirisResultaatTypeDto;
import nl.hu.curcon.dtomapper.Domain2DtoMapper;
import nl.hu.curcon.service.OsirisResultaatTypeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author berend.wilkens
 *
 */
@Service
public class OsirisResultaatTypeServiceImpl extends GenericService implements OsirisResultaatTypeService{
    @Autowired
    private OsirisResultaatTypeDao osirisResultaatTypeDao;

    @Override
    public OsirisResultaatTypeDto create(OsirisResultaatTypeDto osirisResultaatTypeDto) {
    	OsirisResultaatType osirisResultaatType = dto2DomainMapper.map(osirisResultaatTypeDto);
        return Domain2DtoMapper.map(osirisResultaatTypeDao.save(osirisResultaatType));
    }

    @Override
    public void delete(int id) {
    	osirisResultaatTypeDao.delete(id);
    }

    @Override
    public OsirisResultaatTypeDto update(OsirisResultaatTypeDto osirisResultaatTypeDto) {
    	OsirisResultaatType osirisResultaatType = dto2DomainMapper.map(osirisResultaatTypeDto);
        return Domain2DtoMapper.map(osirisResultaatTypeDao.update(osirisResultaatType));
    }

	@Override
	public OsirisResultaatTypeDto find(int id) {
        OsirisResultaatType d = osirisResultaatTypeDao.find(id);
        return Domain2DtoMapper.map(d);
	}

	@Override
    public List<OsirisResultaatTypeDto> findAll() {
        List<OsirisResultaatTypeDto> dtos = new ArrayList<OsirisResultaatTypeDto>();
        List<OsirisResultaatType> osirisResultaatTypeen = osirisResultaatTypeDao.findAll();
        for (OsirisResultaatType d: osirisResultaatTypeen){
            dtos.add(Domain2DtoMapper.map(d));
        }
        return dtos;
    }

}
