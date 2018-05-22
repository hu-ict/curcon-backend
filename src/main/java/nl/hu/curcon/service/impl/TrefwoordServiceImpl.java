package nl.hu.curcon.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.hu.curcon.dao.TrefwoordDao;
import nl.hu.curcon.domain.Leerlijn;
import nl.hu.curcon.domain.Trefwoord;
import nl.hu.curcon.dto.competence.TrefwoordDto;
import nl.hu.curcon.dto.post.TrefwoordPostDto;
import nl.hu.curcon.dtomapper.Domain2DtoMapper;
import nl.hu.curcon.service.TrefwoordService;

/**
 * @author berend.wilkens
 *
 */
@Service
public class TrefwoordServiceImpl extends GenericService implements TrefwoordService{
    @Autowired
    private TrefwoordDao trefwoordDao;

    @Override
    public void delete(int id) {
    	trefwoordDao.delete(id);
    }

    @Override
    public boolean update(TrefwoordPostDto trefwoordDto) {
    	Trefwoord trefwoord = dto2DomainMapper.map(trefwoordDto);
        return trefwoordDao.update(trefwoord) != null;
    }

	@Override
	public TrefwoordDto find(int id) {
        Trefwoord d = trefwoordDao.find(id);
        return Domain2DtoMapper.map(d);
	}

	@Override
	public int create(Leerlijn leerlijn, TrefwoordPostDto trefwoordDto) {
    	Trefwoord trefwoord = dto2DomainMapper.map(trefwoordDto);
    	trefwoord.setLeerlijn(leerlijn);
    	trefwoord = trefwoordDao.save(trefwoord);
        return trefwoord.getId();
	}

}
