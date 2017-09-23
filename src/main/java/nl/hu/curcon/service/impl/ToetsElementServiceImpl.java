package nl.hu.curcon.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nl.hu.curcon.dao.BeoordelingsElementDao;
import nl.hu.curcon.dao.ToetsElementDao;
import nl.hu.curcon.domain.BeoordelingsElement;
import nl.hu.curcon.domain.Leerdoel;
import nl.hu.curcon.domain.ToetsElement;
import nl.hu.curcon.dto.ToetsElementDto;
import nl.hu.curcon.dto.post.ToetsElementPostDto;
import nl.hu.curcon.dto.post.ToetsElementPutDto;
import nl.hu.curcon.dtomapper.Domain2DtoMapper;
import nl.hu.curcon.service.ToetsElementService;

/**
 * @author berend.wilkens, 3 mei 2017
 */
@Service
public class ToetsElementServiceImpl extends GenericService implements ToetsElementService{
    @Autowired
    private ToetsElementDao toetsElementDao;
    @Autowired
    private BeoordelingsElementDao beoordelingsElementDao;

    @Override
    public int create(Leerdoel leerdoel, ToetsElementPostDto toetsElementDto) {
    	ToetsElement toetsElement = dto2DomainMapper.map(toetsElementDto);
    	BeoordelingsElement beoordelingsElement = beoordelingsElementDao.find(toetsElementDto.getBeoordelingsElement());
    	if (beoordelingsElement == null) return 0;
    	if (leerdoel.getCursus().getId() != beoordelingsElement.getToets().getCursus().getId()) {return 0;}
    	toetsElement.setLeerdoel(leerdoel);
    	toetsElement.setBeoordelingsElement(beoordelingsElement);
    	toetsElement = toetsElementDao.save(toetsElement);
    	return toetsElement.getId();
    }

    @Override
	@Transactional
    public boolean delete(int toetsElementId) {
    	ToetsElement toetsElement = toetsElementDao.find(toetsElementId);
    	if (toetsElement == null) return false;
    	toetsElementDao.delete(toetsElementId);
    	return true;
    }

    @Override
	@Transactional
    public boolean update(int toetsElementId, ToetsElementPutDto toetsElementDto) {
    	ToetsElement toetsElement = toetsElementDao.find(toetsElementId);
    	if (toetsElement == null) return false;
    	toetsElement.setGewicht(toetsElementDto.getGewicht());
        toetsElementDao.update(toetsElement);
        return true;
    }

	@Override
	public ToetsElementDto find(int id) {
        ToetsElement d = toetsElementDao.find(id);
        return Domain2DtoMapper.map(d);
	}

	@Override
    public List<ToetsElementDto> findAll() {
        List<ToetsElementDto> dtos = new ArrayList<ToetsElementDto>();
        List<ToetsElement> toetsElementen = toetsElementDao.findAll();
        for (ToetsElement d: toetsElementen){
            dtos.add(Domain2DtoMapper.map(d));
        }
        return dtos;
    }


}
