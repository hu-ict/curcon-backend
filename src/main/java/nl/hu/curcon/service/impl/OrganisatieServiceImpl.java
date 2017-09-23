package nl.hu.curcon.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nl.hu.curcon.dao.CursusDao;
import nl.hu.curcon.dao.DocentDao;
import nl.hu.curcon.dao.OrganisatieDao;
import nl.hu.curcon.domain.Cursus;
import nl.hu.curcon.domain.Docent;
import nl.hu.curcon.domain.OpleidingsProfiel;
import nl.hu.curcon.domain.Organisatie;
import nl.hu.curcon.dto.BeroepsTaakDto;
import nl.hu.curcon.dto.CursusDto;
import nl.hu.curcon.dto.DocentDto;
import nl.hu.curcon.dto.OpleidingsProfielDto;
import nl.hu.curcon.dto.OrganisatieDto;
import nl.hu.curcon.dto.post.CursusPostDto;
import nl.hu.curcon.dto.post.DocentPostDto;
import nl.hu.curcon.dto.post.OpleidingsProfielPostDto;
import nl.hu.curcon.dto.post.OrganisatiePostDto;
import nl.hu.curcon.dtomapper.Domain2DtoMapper;
import nl.hu.curcon.service.DocentService;
import nl.hu.curcon.service.OpleidingsProfielService;
import nl.hu.curcon.service.OrganisatieService;

/**
 * @author berend.wilkens, 3 mei 2017
 */
@Service
public class OrganisatieServiceImpl extends GenericService implements OrganisatieService {
	@Autowired
	private OrganisatieDao organisatieDao;
	@Autowired
	private CursusDao cursusDao;
	@Autowired
	private DocentDao docentDao;
	@Autowired
	private OpleidingsProfielService opleidingsProfielService;
	@Autowired
	private DocentService docentService;

	@Override
	@Transactional
	public int create(OrganisatiePostDto organisatieDto) {
		Organisatie organisatie = dto2DomainMapper.map(organisatieDto);
		organisatie = organisatieDao.save(organisatie);
		return organisatie.getId();
	}

	@Override
	@Transactional
	public boolean delete(int organisatieId) {
		Organisatie organisatie = organisatieDao.find(organisatieId);
		if (organisatie == null) { return false; }
		organisatieDao.delete(organisatieId);
		return true;
	}

	@Override
	@Transactional
	public boolean update(int organisatieId, OrganisatiePostDto organisatieDto) {
		Organisatie organisatie = organisatieDao.find(organisatieId);
		if (organisatie == null) { return false; }
		organisatie.setNaam(organisatieDto.getNaam());
		organisatie = organisatieDao.update(organisatie);
		return true;
	}

	@Override
	@Transactional
	public OrganisatieDto find(int id) {
		Organisatie d = organisatieDao.find(id);
		if (d != null) {
			return Domain2DtoMapper.map(d);
		} else {
			return null;
		}
	}

	@Override
	@Transactional
	public List<OrganisatieDto> findAll() {
		List<OrganisatieDto> dtos = new ArrayList<OrganisatieDto>();
		List<Organisatie> organisaties = organisatieDao.findAll();
		for (Organisatie d : organisaties) {
			dtos.add(Domain2DtoMapper.map(d));
		}
		return dtos;
	}

	@Override
	@Transactional
	public List<DocentDto> findDocentenByOrganisatie(int organisatieId) {
		Organisatie o = organisatieDao.find(organisatieId);
		if (o == null)
			return null;
		List<DocentDto> docenten = new ArrayList<>();
		for (Docent docent : o.getDocenten()) {
			docenten.add(Domain2DtoMapper.map(docent));
		}
		return docenten;
	}

	@Transactional
	@Override
	public List<CursusDto> findCursussenByOrganisatie(int organisatieId) {
		Organisatie o = organisatieDao.find(organisatieId);
		if (o == null)
			return null;
		List<CursusDto> cursussen = new ArrayList<>();
		for (Cursus cursus : o.getCursussen()) {
			cursussen.add(Domain2DtoMapper.map(cursus));
		}
		return cursussen;
	}

	@Transactional
	@Override
	public List<OpleidingsProfielDto> findOpleidingsProfielenByOrganisatie(int organisatieId) {
		Organisatie o = organisatieDao.find(organisatieId);
		if (o == null)
			return null;
		List<OpleidingsProfielDto> opleidingsProfielen = new ArrayList<>();
		for (OpleidingsProfiel opleidingsProfiel : o.getOpleidingsProfielen()) {
			opleidingsProfielen.add(Domain2DtoMapper.map(opleidingsProfiel));
		}
		return opleidingsProfielen;
	}

	@Transactional
	@Override
	public int createDocentByOrganisatie(int organisatieId, DocentPostDto docentDto) {
		Organisatie organisatie = organisatieDao.find(organisatieId);
		if (organisatie == null) return 0;
		int docentId = docentService.create(organisatie, docentDto);
		return docentId;
	}

	@Transactional
	@Override
	public int createCursusByOrganisatie(int organisatieId, CursusPostDto cursusDto) {
		Organisatie organisatie = organisatieDao.find(organisatieId);
		if (organisatie == null) return 0;
		Cursus cursus = dto2DomainMapper.map(cursusDto);
		cursus.setOrganisatie(organisatie);
        Docent docent = docentDao.find(cursusDto.getCoordinator());
		if (docent == null)
			return 0;
		cursus.setCursuscoordinator(docent);
		cursusDao.save(cursus);
		return cursus.getId();
	}

	@Override
	@Transactional
	public int createOpleidingsProfielByOrganisatie(int organisatieId,
			OpleidingsProfielPostDto opleidingsProfielDto) {
		Organisatie organisatie = organisatieDao.find(organisatieId);
		if (organisatie == null) return 0;
		
		return opleidingsProfielService.create(organisatie, opleidingsProfielDto);
	}

	@Override
	public List<BeroepsTaakDto> findBeroepsTakenByOrganisatie(int organisatieId) {
		// TODO Auto-generated method stub
		return null;
	}

}
