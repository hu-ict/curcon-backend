package nl.hu.curcon.service.impl;

import java.util.ArrayList;
import java.util.List;

import nl.hu.curcon.dao.BloomNiveauDao;
import nl.hu.curcon.domain.BloomNiveau;
import nl.hu.curcon.dto.BloomNiveauDto;
import nl.hu.curcon.dtomapper.Domain2DtoMapper;
import nl.hu.curcon.service.BloomNiveauService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jayfeurich on 26/06/15.
 */
@Service
public class BloomNiveauServiceImpl extends GenericService implements BloomNiveauService{
    @Autowired
    private BloomNiveauDao bloomNiveauDao;

    @Override
    public BloomNiveauDto create(BloomNiveauDto bloomNiveauDto) {
    	BloomNiveau bloomNiveau = dto2DomainMapper.map(bloomNiveauDto);
        return Domain2DtoMapper.map(bloomNiveauDao.save(bloomNiveau));
    }

    @Override
    public void delete(int id) {
    	bloomNiveauDao.delete(id);
    }

    @Override
    public BloomNiveauDto update(BloomNiveauDto bloomNiveauDto) {
    	BloomNiveau bloomNiveau = dto2DomainMapper.map(bloomNiveauDto);
        return Domain2DtoMapper.map(bloomNiveauDao.update(bloomNiveau));
    }

	@Override
	public BloomNiveauDto find(int id) {
        BloomNiveau d = bloomNiveauDao.find(id);
        return Domain2DtoMapper.map(d);
	}

	@Override
    public List<BloomNiveauDto> findAll() {
        List<BloomNiveauDto> dtos = new ArrayList<BloomNiveauDto>();
        List<BloomNiveau> bloomNiveaus = bloomNiveauDao.findAll();
        for (BloomNiveau d: bloomNiveaus){
            dtos.add(Domain2DtoMapper.map(d));
        }
        return dtos;
    }

}
