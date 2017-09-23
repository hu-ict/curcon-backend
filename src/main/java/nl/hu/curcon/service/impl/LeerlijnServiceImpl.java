package nl.hu.curcon.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.hu.curcon.dao.LeerlijnDao;
import nl.hu.curcon.domain.Leerlijn;
import nl.hu.curcon.domain.Trefwoord;
import nl.hu.curcon.dto.LeerlijnDto;
import nl.hu.curcon.dto.TrefwoordDto;
import nl.hu.curcon.dto.post.LeerlijnPostDto;
import nl.hu.curcon.dto.post.TrefwoordPostDto;
import nl.hu.curcon.dtomapper.Domain2DtoMapper;
import nl.hu.curcon.service.LeerlijnService;
import nl.hu.curcon.service.TrefwoordService;

/**
 * @author berend.wilkens, 1 jun. 2017
 */
@Service
public class LeerlijnServiceImpl extends GenericService implements LeerlijnService{
    @Autowired
    private LeerlijnDao leerlijnDao;
    @Autowired
	private TrefwoordService trefwoordService;

    @Override
    public LeerlijnDto create(LeerlijnPostDto leerlijnDto) {
    	Leerlijn leerlijn = dto2DomainMapper.map(leerlijnDto);
        return Domain2DtoMapper.map(leerlijnDao.save(leerlijn));
    }

    @Override
    public void delete(int leerlijnId) {
    	leerlijnDao.delete(leerlijnId);
    }

    @Override
    public LeerlijnDto update(LeerlijnPostDto leerlijnDto) {
    	Leerlijn leerlijn = dto2DomainMapper.map(leerlijnDto);
        return Domain2DtoMapper.map(leerlijnDao.update(leerlijn));
    }

	@Override
	public LeerlijnDto find(int leerlijnId) {
        Leerlijn d = leerlijnDao.find(leerlijnId);
        return Domain2DtoMapper.map(d);
	}

	@Override
    public List<LeerlijnDto> findAll() {
        List<LeerlijnDto> dtos = new ArrayList<LeerlijnDto>();
        List<Leerlijn> leerlijnen = leerlijnDao.findAll();
        for (Leerlijn d: leerlijnen){
            dtos.add(Domain2DtoMapper.map(d));
        }
        return dtos;
    }

	@Override
	public int createTrefwoordByLeerlijn(int leerlijnId, TrefwoordPostDto trefwoordDto) {
        Leerlijn leerlijn = leerlijnDao.find(leerlijnId);
		if (leerlijn == null) return 0;
		int trefwoordId = trefwoordService.create(leerlijn, trefwoordDto);
		return trefwoordId;
	}

	@Override
	public List<TrefwoordDto> findTrefwoordenByLeerlijn(int leerlijnId) {
        Leerlijn leerlijn = leerlijnDao.find(leerlijnId);
		if (leerlijn == null)
			return null;
		List<TrefwoordDto> dtos = new ArrayList<>();
		for (Trefwoord trefwoord : leerlijn.getTrefwoorden()) {
			dtos.add(Domain2DtoMapper.map(trefwoord));
		}
		return dtos;
	}

}
