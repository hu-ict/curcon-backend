package nl.hu.curcon.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.hu.curcon.dao.MillerNiveauDao;
import nl.hu.curcon.domain.MillerNiveau;
import nl.hu.curcon.dto.MillerNiveauDto;
import nl.hu.curcon.dtomapper.Domain2DtoMapper;
import nl.hu.curcon.service.MillerNiveauService;

/**
 * @author berend.wilkens
 *
 */
@Service
public class MillerNiveauServiceImpl extends GenericService implements MillerNiveauService{
    @Autowired
    private MillerNiveauDao millerNiveauDao;

 	@Override
	public MillerNiveauDto find(int id) {
 		MillerNiveau m = millerNiveauDao.find(id);
        return Domain2DtoMapper.map(m);
	}

	@Override
    public List<MillerNiveauDto> findAll() {
        List<MillerNiveauDto> dtos = new ArrayList<MillerNiveauDto>();
        List<MillerNiveau> millerNiveau = millerNiveauDao.findAll();
        for (MillerNiveau m: millerNiveau){
            dtos.add(Domain2DtoMapper.map(m));
        }
        return dtos;
    }

}
