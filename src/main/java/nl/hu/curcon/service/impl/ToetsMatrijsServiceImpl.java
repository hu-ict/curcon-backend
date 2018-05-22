package nl.hu.curcon.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.hu.curcon.dao.CursusDao;
import nl.hu.curcon.domain.Cursus;
import nl.hu.curcon.dto.ToetsMatrijsDto;
import nl.hu.curcon.dtomapper.Domain2DtoMapperToetsMatrijs;
import nl.hu.curcon.service.ToetsMatrijsService;

/**
 * @author berend.wilkens, 24 mrt. 2017
 * ToetsMatrijsServiceImpl
 */
@Service
public class ToetsMatrijsServiceImpl extends GenericService implements ToetsMatrijsService{
    @Autowired
    private CursusDao cursusDao;

	@Override
	public ToetsMatrijsDto find(int id) {
        Cursus d = cursusDao.find(id);
        return Domain2DtoMapperToetsMatrijs.mapToetsMatrijs(d);
	}

}
