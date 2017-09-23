package nl.hu.curcon.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.hu.curcon.dao.DocentDao;
import nl.hu.curcon.domain.Docent;
import nl.hu.curcon.domain.Organisatie;
import nl.hu.curcon.dto.DocentDto;
import nl.hu.curcon.dto.post.DocentPostDto;
import nl.hu.curcon.dtomapper.Domain2DtoMapper;
import nl.hu.curcon.service.DocentService;

/**
 * @author berend.wilkens, 4 mei 2017
 */
@Service
public class DocentServiceImpl extends GenericService implements DocentService{
    @Autowired
    private DocentDao docentDao;

    @Override
    public int create(Organisatie organisatie, DocentPostDto docentDto) {
    	Docent docent = dto2DomainMapper.map(docentDto);
    	docent.setOrganisatie(organisatie);
    	docent = docentDao.save(docent);
        return docent.getId();
    }

    @Override
    public void delete(int id) {
    	docentDao.delete(id);
    }

    @Override
    public boolean update(int docentId, DocentPostDto docentDto) {
    	Docent docent = docentDao.find(docentId);
    	docent.setNaam(docentDto.getNaam());
    	docentDao.update(docent);
        return true;
    }

	@Override
	public DocentDto find(int id) {
        Docent d = docentDao.find(id);
        return Domain2DtoMapper.map(d);
	}

	@Override
    public List<DocentDto> findAll() {
        List<DocentDto> dtos = new ArrayList<DocentDto>();
        List<Docent> docenten = docentDao.findAll("naam asc");
        for (Docent d: docenten){
            dtos.add(Domain2DtoMapper.map(d));
        }
        return dtos;
    }

}
