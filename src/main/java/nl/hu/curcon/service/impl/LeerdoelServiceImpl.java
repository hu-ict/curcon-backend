package nl.hu.curcon.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nl.hu.curcon.dao.BeroepsTaakDao;
import nl.hu.curcon.dao.BloomNiveauDao;
import nl.hu.curcon.dao.LeerdoelDao;
import nl.hu.curcon.dao.ProfessionalSkillDao;
import nl.hu.curcon.domain.BeroepsTaak;
import nl.hu.curcon.domain.BloomNiveau;
import nl.hu.curcon.domain.Cursus;
import nl.hu.curcon.domain.Leerdoel;
import nl.hu.curcon.domain.ProfessionalSkill;
import nl.hu.curcon.domain.ToetsElement;
import nl.hu.curcon.dto.LeerdoelDto;
import nl.hu.curcon.dto.ToetsElementDto;
import nl.hu.curcon.dto.post.LeerdoelPostDto;
import nl.hu.curcon.dto.post.ToetsElementPostDto;
import nl.hu.curcon.dtomapper.Domain2DtoMapper;
import nl.hu.curcon.service.LeerdoelService;
import nl.hu.curcon.service.ToetsElementService;

/**
 * @author berend.wilkens, 17 aug. 2017
 */
@Service
public class LeerdoelServiceImpl extends GenericService implements LeerdoelService {
	@Autowired
	private LeerdoelDao leerdoelDao;
	@Autowired
	private BloomNiveauDao bloomNiveauDao;
	@Autowired
	private BeroepsTaakDao beroepsTaakDao;
	@Autowired
	private ProfessionalSkillDao professionalSkillDao;
	@Autowired
	private ToetsElementService toetsElementService;

	@Override
	public int create(Cursus cursus, LeerdoelPostDto leerdoelDto) {
		BloomNiveau bloomNiveau = bloomNiveauDao.find(leerdoelDto.getBloomniveau());
		if (bloomNiveau == null)
			return 0;
		BeroepsTaak beroepsTaak = beroepsTaakDao.find(leerdoelDto.getEindBT());
		if (beroepsTaak == null)
			return 0;
		ProfessionalSkill professionalSkill = professionalSkillDao.find(leerdoelDto.getEindPS());
		if (professionalSkill == null)
			return 0;
		Leerdoel leerdoel = dto2DomainMapper.map(leerdoelDto);
		leerdoel.setCursus(cursus);
		leerdoel.setBloomNiveau(bloomNiveau);
		leerdoel.setBeroepsTaak(beroepsTaak);
		leerdoel.setProfessionalSkill(professionalSkill);
		leerdoel = leerdoelDao.save(leerdoel);
		return leerdoel.getId();
	}

	@Override
	@Transactional
	public void delete(int id) {
		leerdoelDao.delete(id);
	}

	@Override
	public boolean update(int leerdoelId, LeerdoelPostDto leerdoelDto) {
		Leerdoel leerdoel = leerdoelDao.find(leerdoelId);
		if (leerdoel == null)
			return false;
		BloomNiveau bloomNiveau = bloomNiveauDao.find(leerdoelDto.getBloomniveau());
		if (bloomNiveau == null)
			return false;
		BeroepsTaak beroepsTaak = beroepsTaakDao.find(leerdoelDto.getEindBT());
		if (beroepsTaak == null)
			return false;
		ProfessionalSkill professionalSkill = professionalSkillDao.find(leerdoelDto.getEindPS());
		if (professionalSkill == null)
			return false;
		leerdoel.setOmschrijving(leerdoelDto.getOmschrijving());
		leerdoel.setGewicht(leerdoelDto.getGewicht());
		leerdoel.setProfessionalSkill(professionalSkill);
		leerdoel.setBeroepsTaak(beroepsTaak);
		leerdoel.setBloomNiveau(bloomNiveau);
		leerdoelDao.update(leerdoel);
		return true;
	}

	@Override
	@Transactional
	public LeerdoelDto find(int id) {
		Leerdoel d = leerdoelDao.find(id);
		if (d == null) {
			return null;
		} else {
			return Domain2DtoMapper.map(d);
		}
	}

	@Override
	@Transactional
	public List<LeerdoelDto> findAll() {
		List<LeerdoelDto> dtos = new ArrayList<LeerdoelDto>();
		List<Leerdoel> leerdoelen = leerdoelDao.findAll();
		for (Leerdoel d : leerdoelen) {
			dtos.add(Domain2DtoMapper.map(d));
		}
		return dtos;
	}

	@Override
	public List<ToetsElementDto> getToetslementenByLeerdoel(int leerdoelId) {
		Leerdoel leerdoel = leerdoelDao.find(leerdoelId);
		if (leerdoel == null)
			return null;
		List<ToetsElementDto> toetsElementen = new ArrayList<>();
		for (ToetsElement toetsElement : leerdoel.getToetsElementen()) {
			toetsElementen.add(Domain2DtoMapper.map(toetsElement));
		}
		return toetsElementen;
	}

	@Override
	@Transactional
	public int createToetsElementByLeerdoel(int leerdoelId, ToetsElementPostDto toetsElementDto) {
		Leerdoel leerdoel = leerdoelDao.find(leerdoelId);
		if (leerdoel == null)
			return 0;
		return toetsElementService.create(leerdoel, toetsElementDto);
	}

}
