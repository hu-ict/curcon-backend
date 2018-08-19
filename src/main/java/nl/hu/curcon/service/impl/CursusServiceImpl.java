package nl.hu.curcon.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.hu.curcon.dao.BeroepsTaakDao;
import nl.hu.curcon.dao.CursusDao;
import nl.hu.curcon.dao.DocentDao;
import nl.hu.curcon.dao.ProfessionalSkillDao;
import nl.hu.curcon.domain.BeoordelingsElement;
import nl.hu.curcon.domain.Cursus;
import nl.hu.curcon.domain.Docent;
import nl.hu.curcon.domain.Leerdoel;
import nl.hu.curcon.domain.ProfessionalSkill;
import nl.hu.curcon.domain.Toets;
import nl.hu.curcon.domain.ToetsElement;
import nl.hu.curcon.domain.hboi.BeroepsTaak;
import nl.hu.curcon.dto.CursusDto;
import nl.hu.curcon.dto.LeerdoelDto;
import nl.hu.curcon.dto.ToetsDto;
import nl.hu.curcon.dto.competence.BeroepsTaakDto;
import nl.hu.curcon.dto.competence.ProfessionalSkillDto;
import nl.hu.curcon.dto.post.CursusPostDto;
import nl.hu.curcon.dto.post.LeerdoelPostDto;
import nl.hu.curcon.dto.post.ToetsPostDto;
import nl.hu.curcon.dtomapper.Domain2DtoMapper;
import nl.hu.curcon.service.CursusService;
import nl.hu.curcon.service.LeerdoelService;
import nl.hu.curcon.service.ToetsService;

/**
 * @author berend.wilkens, 2 mei 2017
 */
@Service
public class CursusServiceImpl extends GenericService implements CursusService {
	@Autowired
	private CursusDao cursusDao;
	@Autowired
	private DocentDao docentDao;
	@Autowired
	private BeroepsTaakDao beroepsTaakDao;
	@Autowired
	private ProfessionalSkillDao professionalSkillDao;
	@Autowired
	private LeerdoelService leerdoelService;
	@Autowired
	private ToetsService toetsService;

	@SuppressWarnings("unused")
	private static final Logger LOG = LoggerFactory.getLogger(CursusServiceImpl.class);

	// @Override
	// public CursusDto create(CursusDto cursusDto) {
	// Cursus cursus = dto2DomainMapper.map(cursusDto);
	// return Domain2DtoMapper.map(cursusDao.save(cursus));
	// }

	@Override
	public void delete(int id) {
		cursusDao.delete(id);
	}

	@Override
	public boolean update(int cursusId, CursusPostDto cursusDto) {
		Cursus cursus = cursusDao.find(cursusId);
		if (cursus == null) {
			return false;
		} else {
			cursus.setCursusCode(cursusDto.getCode());
			cursus.setEuropeanCredits(cursusDto.getEuropeanCredits());
			cursus.setNaam(cursusDto.getNaam());
			cursus.setPeriode(cursusDto.getPeriode());
			Docent docent = docentDao.find(cursusDto.getCoordinator());
			cursus.setCursuscoordinator(docent);
			cursusDao.update(cursus);
			return true;
		}
	}

	@Override
	public CursusDto find(int id) {
		Cursus d = cursusDao.find(id);
		return Domain2DtoMapper.map(d);
	}

	@Override
	public List<CursusDto> findAll() {
		List<CursusDto> dtos = new ArrayList<CursusDto>();
		List<Cursus> cursusen = cursusDao.findAll();
		for (Cursus d : cursusen) {
			dtos.add(Domain2DtoMapper.map(d));
		}
		return dtos;
	}

	public List<LeerdoelDto> getLeerdoelenByCursus(int id) {
		Cursus d = cursusDao.find(id);
		if (d == null)
			return null;
		List<LeerdoelDto> leerdoelen = new ArrayList<>();
		for (Leerdoel leerdoel : d.getLeerdoelen()) {
			leerdoelen.add(Domain2DtoMapper.map(leerdoel));
		}
		return leerdoelen;
	}

	public List<ToetsDto> getToetsenByCursus(int id) {
		Cursus c = cursusDao.find(id);
		if (c == null)
			return null;
		List<ToetsDto> toetsen = new ArrayList<>();
		for (Toets toets : c.getToetsen()) {
			toetsen.add(Domain2DtoMapper.map(toets));
		}
		return toetsen;
	}

	@Override
	public boolean addBeroepsTaakToCursus(int cursusId, int beroepsTaakId) {
		Cursus c = cursusDao.find(cursusId);
		if (c == null)
			return false;
		BeroepsTaak b = beroepsTaakDao.find(beroepsTaakId);
		if (b == null)
			return false;
		if (c.getEindBTs().contains(b))
			return false;
		c.getEindBTs().add(b);
		cursusDao.save(c);
		return true;
	}

	@Override
	public boolean setDocentToCursus(int cursusId, int docentId) {
		Cursus cursus = cursusDao.find(cursusId);
		if (cursus == null)
			return false;
		Docent docent = docentDao.find(docentId);
		if (!cursus.getOrganisatie().getDocenten().contains(docent))
			return false;
		if (docent == null)
			return false;
		cursus.setCursuscoordinator(docent);
		cursusDao.save(cursus);
		return true;
	}

	@Override
	public boolean removeBeroepsTaakFromCursus(int cursusId, int beroepstaakId) {
		Cursus c = cursusDao.find(cursusId);
		if (c == null)
			return false;
		BeroepsTaak b = beroepsTaakDao.find(beroepstaakId);
		if (b == null)
			return false;
		if (!c.getEindBTs().contains(b))
			return false;
		c.getEindBTs().remove(b);
		cursusDao.save(c);
		return true;
	}

	@Override
	public List<BeroepsTaakDto> getBeroepsTakenByCursus(int id) {
		Cursus c = cursusDao.find(id);
		if (c == null)
			return null;
		List<BeroepsTaakDto> beroepsTaken = new ArrayList<>();
		for (BeroepsTaak beroepsTaak : c.getEindBTs()) {
			beroepsTaken.add(Domain2DtoMapper.map(beroepsTaak));
		}
		return beroepsTaken;
	}

	@Override
	public int createLeerdoelByCursus(int cursusId, LeerdoelPostDto leerdoelDto) {
		Cursus cursus = cursusDao.find(cursusId);
		if (cursus == null)
			return 0;
		return leerdoelService.create(cursus, leerdoelDto);
	}

	@Override
	public int createToetsByCursus(int cursusId, ToetsPostDto toetsDto) {
		Cursus cursus = cursusDao.find(cursusId);
		if (cursus == null)
			return 0;
		return toetsService.create(cursus, toetsDto);
	}

	@Override
	public boolean removeProfessionalSkillFromCursus(int cursusId, int professionalskillId) {
		Cursus c = cursusDao.find(cursusId);
		if (c == null)
			return false;
		ProfessionalSkill p = professionalSkillDao.find(professionalskillId);
		if (p == null)
			return false;
		if (!c.getEindPSs().contains(p))
			return false;
		c.getEindPSs().remove(p);
		cursusDao.save(c);
		return true;
	}

	@Override
	public boolean addProfessionalSkillToCursus(int cursusId, int id) {
		Cursus c = cursusDao.find(cursusId);
		if (c == null)
			return false;
		ProfessionalSkill p = professionalSkillDao.find(id);
		if (p == null)
			return false;
		if (c.getEindBTs().contains(p))
			return false;
		c.getEindPSs().add(p);
		cursusDao.save(c);
		return true;
	}

	@Override
	public List<ProfessionalSkillDto> getProfessionalSkillsByCursus(int id) {
		Cursus c = cursusDao.find(id);
		if (c == null)
			return null;
		List<ProfessionalSkillDto> professionalSkills = new ArrayList<>();
		for (ProfessionalSkill professionalSkill : c.getEindPSs()) {
			professionalSkills.add(Domain2DtoMapper.map(professionalSkill));
		}
		return professionalSkills;
	}

	@Override
	public List<String> check(int cursusId) {
		List<String> opmerkingen = new ArrayList<>();
		Cursus cursus = cursusDao.find(cursusId);

		if (cursus.getEindBTs().size() == 0) {
			opmerkingen.add("[" + cursus.getCursusCode() + "] Cursus heeft geen beroepstaken gekoppeld");
		}

		if (cursus.getLeerdoelen().size() == 0) {
			opmerkingen.add("[" + cursus.getCursusCode() + "] Cursus heeft geen leerdoelen");
		} else {
			if (cursus.getEindBTs().size() != 0) {
				for (BeroepsTaak beroepsTaak : cursus.getEindBTs()) {
					boolean found = false;
					for (Leerdoel leerdoel : cursus.getLeerdoelen()) {
						if (beroepsTaak.equals(leerdoel.getBeroepsTaak())) {
							found = true;
							break;
						}
					}
					if (!found) {
						opmerkingen.add("[" + cursus.getCursusCode() + "] Beroepstaak (" + beroepsTaak
								+ ") is niet gekoppeld aan een leerdoel");
					}
				}
			}
			double cursusGewicht = 0.0;
			for (Leerdoel leerdoel : cursus.getLeerdoelen()) {
				cursusGewicht += leerdoel.getGewicht();
				double toetsElementGewicht = 0.0;
				for (ToetsElement toetsElement : leerdoel.getToetsElementen()) {
					toetsElementGewicht += toetsElement.getGewicht();
				}
				if (toetsElementGewicht != leerdoel.getGewicht())
					opmerkingen.add("[" + cursus.getCursusCode() + "] Het gewicht (" + toetsElementGewicht
							+ ") van het leerdoel (" + leerdoel.getNaam() + ") is ongelijk het beoogde gewicht "
							+ leerdoel.getGewicht());
			}
			if (cursusGewicht != 100.0) {
				opmerkingen.add("[" + cursus.getCursusCode() + "] Het totale gewicht (" + cursusGewicht
						+ ") van de leerdoelen is ongelijk 100");
			}

		}

		if (cursus.getToetsen().size() == 0) {
			opmerkingen.add("[" + cursus.getCursusCode() + "] Cursus heeft geen toetsen");
		} else {
			double toetsGewicht = 0.0;
			for (Toets toets : cursus.getToetsen()) {
				toetsGewicht += toets.getGewicht();
				if (toets.getBeoordelingsElementen().size() == 0) {
					opmerkingen.add("[" + cursus.getCursusCode() + "] Cursus heeft toets (" + toets.getNaam()
							+ ") zonder beoordelingselementen");
				} else {
					double elementGewicht = 0.0;
					for (BeoordelingsElement element : toets.getBeoordelingsElementen()) {
						elementGewicht += element.getGewicht();
						double toetsElementGewicht = 0.0;
						for (ToetsElement toetsElement : element.getToetsElementen()) {
							toetsElementGewicht += toetsElement.getGewicht();
						}
						if (toetsElementGewicht != element.getGewicht())
							opmerkingen.add("[" + cursus.getCursusCode() + "] Het gewicht (" + toetsElementGewicht
									+ ") van het beoordelingselement (" + element.getNaam() + ") binnen de toets ["
									+ toets.getNaam() + "] is ongelijk het beoogde gewicht " + element.getGewicht());
					}
					if (elementGewicht != 100.0) {
						opmerkingen.add("[" + cursus.getCursusCode() + "] Het totale gewicht (" + elementGewicht
								+ ") van de beoordelingselementen binnen de toets [" + toets.getNaam()
								+ "] is ongelijk 100");
					}
				}

			}
			if (toetsGewicht != 100.0) {
				opmerkingen.add("[" + cursus.getCursusCode() + "] Het totale gewicht (" + toetsGewicht
						+ ") van de toetsen is ongelijk 100");
			}
		}


		return opmerkingen;

	}
}
