package nl.hu.curcon.service.impl;

import java.util.ArrayList;
import java.util.List;

import nl.hu.curcon.dao.PeriodeDao;
import nl.hu.curcon.domain.Periode;
import nl.hu.curcon.dto.PeriodeDto;
import nl.hu.curcon.dtomapper.Domain2DtoMapper;
import nl.hu.curcon.service.PeriodeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author berend.wilkens
 *
 */
@Service
public class PeriodeServiceImpl extends GenericService implements PeriodeService{
    @Autowired
    private PeriodeDao periodeDao;

    @Override
    public PeriodeDto create(PeriodeDto periodeDto) {
    	Periode periode = dto2DomainMapper.map(periodeDto);
        return Domain2DtoMapper.map(periodeDao.save(periode));
    }

    @Override
    public void delete(int id) {
    	periodeDao.delete(id);
    }

    @Override
    public PeriodeDto update(PeriodeDto periodeDto) {
    	Periode periode = dto2DomainMapper.map(periodeDto);
        return Domain2DtoMapper.map(periodeDao.update(periode));
    }

	@Override
	public PeriodeDto find(int id) {
        Periode d = periodeDao.find(id);
        return Domain2DtoMapper.map(d);
	}

	@Override
    public List<PeriodeDto> findAll() {
        List<PeriodeDto> dtos = new ArrayList<PeriodeDto>();
        List<Periode> periodeen = periodeDao.findAll();
        for (Periode d: periodeen){
            dtos.add(Domain2DtoMapper.map(d));
        }
        return dtos;
    }

}
