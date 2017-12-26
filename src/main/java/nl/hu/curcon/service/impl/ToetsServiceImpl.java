package nl.hu.curcon.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.hu.curcon.dao.MillerNiveauDao;
import nl.hu.curcon.dao.ToetsDao;
import nl.hu.curcon.domain.BeoordelingsElement;
import nl.hu.curcon.domain.Cursus;
import nl.hu.curcon.domain.MillerNiveau;
import nl.hu.curcon.domain.Toets;
import nl.hu.curcon.dto.BeoordelingsElementDto;
import nl.hu.curcon.dto.ToetsDto;
import nl.hu.curcon.dto.post.BeoordelingsElementPostDto;
import nl.hu.curcon.dto.post.ToetsPostDto;
import nl.hu.curcon.dtomapper.Domain2DtoMapper;
import nl.hu.curcon.service.BeoordelingsElementService;
import nl.hu.curcon.service.ToetsService;

/**
 * @author berend.wilkens, 3 mei 2017
 */
@Service
public class ToetsServiceImpl extends GenericService implements ToetsService {
	@Autowired
	private ToetsDao toetsDao;
	@Autowired
	private MillerNiveauDao millerNiveauDao;
	@Autowired
	private BeoordelingsElementService beoordelingsElementService;

	@Override
	@Transactional
	public int create(Cursus cursus, ToetsPostDto toetsDto) {
		MillerNiveau millerNiveau = millerNiveauDao.find(toetsDto.getMillerNiveau());
		if (millerNiveau == null)
			return 0;
		Toets toets = dto2DomainMapper.map(toetsDto);
		toets.setCursus(cursus);
		toets.setMillerNiveau(millerNiveau);
		toetsDao.save(toets);
		return toets.getId();
	}

	@Override
	public void delete(int id) {
		toetsDao.delete(id);
	}

	@Override
	@Transactional
	public boolean update(int toetsId, ToetsPostDto toetsDto) {
		Toets toets = toetsDao.find(toetsId);
		if (toets == null)
			return false;
		MillerNiveau millerNiveau = millerNiveauDao.find(toetsDto.getMillerNiveau());
		if (millerNiveau == null)
			return false;
		toets.setGewicht(toetsDto.getGewicht());
		toets.setNaam(toetsDto.getNaam());
		toets.setMillerNiveau(millerNiveau);
		return true;
	}

	@Override
	@Transactional
	public ToetsDto find(int id) {
		Toets d = toetsDao.find(id);
		return Domain2DtoMapper.map(d);
	}

	@Override
	@Transactional
	public int createBeoordelingsElementByToets(int toetsId, BeoordelingsElementPostDto beoordelingsElementDto) {
		Toets toets = toetsDao.find(toetsId);
		if (toets == null)
			return 0;
		return beoordelingsElementService.create(toets, beoordelingsElementDto);
	}

	@Override
	@Transactional
    public List<BeoordelingsElementDto> findBeoordelingsElementenByToets(int toetsId) {
		Toets t = toetsDao.find(toetsId);
		if (t == null)
			return null;
		List<BeoordelingsElementDto> dtos = new ArrayList<>();

		List<BeoordelingsElement> beoordelingsElementen = t.getBeoordelingsElementen();
        for (BeoordelingsElement b: beoordelingsElementen){
            dtos.add(Domain2DtoMapper.map(b));
        }
        return dtos;
    }
}
