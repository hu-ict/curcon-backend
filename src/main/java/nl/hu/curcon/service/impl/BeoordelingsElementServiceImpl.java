package nl.hu.curcon.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nl.hu.curcon.dao.BeoordelingsElementDao;
import nl.hu.curcon.domain.BeoordelingsElement;
import nl.hu.curcon.domain.Toets;
import nl.hu.curcon.domain.ToetsElement;
import nl.hu.curcon.dto.BeoordelingsElementDto;
import nl.hu.curcon.dto.ToetsElementDto;
import nl.hu.curcon.dto.post.BeoordelingsElementPostDto;
import nl.hu.curcon.dtomapper.Domain2DtoMapper;
import nl.hu.curcon.service.BeoordelingsElementService;

/**
 * @author berend.wilkens, 8 jun. 2017
 */
@Service
public class BeoordelingsElementServiceImpl extends GenericService implements BeoordelingsElementService {
	@Autowired
	private BeoordelingsElementDao beoordelingsElementDao;

	@Override
	@Transactional
	public boolean delete(int beoordelingsElementId) {
		BeoordelingsElement beoordelingsElement = beoordelingsElementDao.find(beoordelingsElementId);
		if (beoordelingsElement == null) {
			return false;
		}
		beoordelingsElementDao.deleteCascade(beoordelingsElementId);
		return true;
	}

	@Override
	@Transactional
	public boolean update(int beoordelingsElementId, BeoordelingsElementPostDto beoordelingsElementDto) {
		BeoordelingsElement beoordelingsElement = beoordelingsElementDao.find(beoordelingsElementId);
		if (beoordelingsElement == null) {
			return false;
		}
		beoordelingsElement.setGewicht(beoordelingsElementDto.getGewicht());
		beoordelingsElement.setNaam(beoordelingsElementDto.getNaam());
		beoordelingsElement.setOmschrijving(beoordelingsElementDto.getOmschrijving());
		return beoordelingsElementDao.update(beoordelingsElement) != null;
	}

	@Override
	@Transactional
	public BeoordelingsElementDto find(int id) {
		BeoordelingsElement d = beoordelingsElementDao.find(id);
		return Domain2DtoMapper.map(d);
	}

	@Override
	@Transactional
	public int create(Toets toets, BeoordelingsElementPostDto beoordelingsElementDto) {
		BeoordelingsElement beoordelingsElement = dto2DomainMapper.map(beoordelingsElementDto);
		beoordelingsElement.setToets(toets);
		beoordelingsElement = beoordelingsElementDao.save(beoordelingsElement);
		return beoordelingsElement.getId();
	}

	@Override
	@Transactional
	public List<ToetsElementDto> getToetslementenByBeoordelingsElement(int beoordelingsElementId) {
		BeoordelingsElement beoordelingsElement = beoordelingsElementDao.find(beoordelingsElementId);
		if (beoordelingsElement == null)
			return null;
		List<ToetsElementDto> toetsElementen = new ArrayList<>();
		for (ToetsElement toetsElement : beoordelingsElement.getToetsElementen()) {
			toetsElementen.add(Domain2DtoMapper.map(toetsElement));
		}
		return toetsElementen;
	}

}
