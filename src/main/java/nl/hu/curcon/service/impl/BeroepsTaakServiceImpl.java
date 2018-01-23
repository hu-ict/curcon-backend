package nl.hu.curcon.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.hu.curcon.dao.BeroepsTaakDao;
import nl.hu.curcon.domain.BeroepsTaak;
import nl.hu.curcon.dto.competence.ActiviteitDto;
import nl.hu.curcon.dto.competence.ArchitectuurLaagDto;
import nl.hu.curcon.dto.competence.BeroepsTaakDto;
import nl.hu.curcon.dto.competence.BeroepsTaakTypesDto;
import nl.hu.curcon.dtomapper.Domain2DtoMapper;
import nl.hu.curcon.service.BeroepsTaakService;

/**
 * @author berend.wilkens, 18 mei 2017
 */
@Service
public class BeroepsTaakServiceImpl extends GenericService implements BeroepsTaakService{
    @Autowired
    private BeroepsTaakDao beroepsTaakDao;

	@Override
	public BeroepsTaakDto find(int id) {
        BeroepsTaak beroepsTaak = beroepsTaakDao.find(id);
        return Domain2DtoMapper.map(beroepsTaak);
	}

	@Override
    public List<BeroepsTaakDto> findAll() {
        List<BeroepsTaakDto> dtos = new ArrayList<BeroepsTaakDto>();
        List<BeroepsTaak> beroepsTaken = beroepsTaakDao.findAll();
        for (BeroepsTaak d: beroepsTaken){
            dtos.add(Domain2DtoMapper.map(d));
        }
        return dtos;
    }

	/* (non-Javadoc)
	 * @see nl.hu.curcon.service.BeroepsTaakService#findTypes()
	 * Tijdelijk een hard coded oplossing.
	 */
	@Override
	public BeroepsTaakTypesDto findTypes() {
		BeroepsTaakTypesDto beroepsTaakTypesDto = new BeroepsTaakTypesDto();
		beroepsTaakTypesDto.getActiviteiten().add(new ActiviteitDto(1, "Beheren", "Het beheersbaar laten verlopen van alle activiteiten gericht op het proces van ontwikkeling, ingebruikname  en gebruik van ict-systemen."));
		beroepsTaakTypesDto.getActiviteiten().add(new ActiviteitDto(2, "Analyseren", "Het analyseren van processen, producten en informatiestromen  in hun onderlinge samenhang en de context van de omgeving."));
		beroepsTaakTypesDto.getActiviteiten().add(new ActiviteitDto(3, "Adviseren", "Het adviseren over de herinrichting van processen en/of informatiestromen  en voor een nieuw te ontwikkelen of aan te schaffen ict-systeem op basis van een analyse en in overleg met stakeholders."));
		beroepsTaakTypesDto.getActiviteiten().add(new ActiviteitDto(4, "Ontwerpen", "Het ontwerpen van een ict-systeem op basis van specificaties en binnen vooraf gestelde kaders."));
		beroepsTaakTypesDto.getActiviteiten().add(new ActiviteitDto(5, "Realiseren", "Het realiseren van een ict-systeem op basis van een ontwerp en binnen gestelde kaders."));

		beroepsTaakTypesDto.getArchitectuurLagen().add(new ArchitectuurLaagDto(1, "Gebruikersinteractie", "Gebruikersinteractie heeft betrekking op de communicatie van de (eind)gebruiker)  met het ict-systeem. Hier wordt nadrukkelijk niet de interactie bedoeld met gebruikers zoals die plaatsvindt tijdens het tot stand komen van een ict-systeem; dat is immers in elk van de architectuurlagen  aan de orde."));
		beroepsTaakTypesDto.getArchitectuurLagen().add(new ArchitectuurLaagDto(2, "Bedrijfsprocessen", "Bedrijfsprocessen heeft betrekking op het faciliteren van organisatieprocessen door middel van ict-systemen. Daarbij gaat het om de functionaliteit van het systeem als geheel (geautomatiseerde  en niet geautomatiseerde  delen) bezien vanuit de context van de te realiseren organisatiedoelen."));
		beroepsTaakTypesDto.getArchitectuurLagen().add(new ArchitectuurLaagDto(3, "Infrastructuur", "Infrastructuur betreft het geheel aan ict-systemen waarmee bedrijfsprocessen  gefaciliteerd worden. Het gaat hier om beschikbaar stellen, beschikbaar houden en configureren van de traditionele hardware-infrastructuur, maar zeker ook de software-infrastructuur."));
		beroepsTaakTypesDto.getArchitectuurLagen().add(new ArchitectuurLaagDto(4, "Software", "Software betreft het ontwikkelen van diverse soorten software. Dit betreft software die na oplevering wordt opgenomen in een ict-infrastructuur."));
		beroepsTaakTypesDto.getArchitectuurLagen().add(new ArchitectuurLaagDto(5, "Hardware Interfacing", "Hardware Interfacing is van toepassing wanneer software interactie aangaat met beschikbare hardware. Hierbij gaat het om situaties waarbij in de software expliciet rekening gehouden moet worden met mogelijkheden  en beperkingen van de beschikbare hardware. Gekozen is voor ‘computersysteem’  als generieke, overkoepelende  term. Afhankelijk van de context kan dit nader gespecificeerd  worden in 'embedded systeem', 'industrial automation', 'virtueel systeem' e.d."));
		
		beroepsTaakTypesDto.getNiveaus().add(new Integer(1));
		beroepsTaakTypesDto.getNiveaus().add(new Integer(2));
		beroepsTaakTypesDto.getNiveaus().add(new Integer(3));
		
		return beroepsTaakTypesDto;
	}

	@Override
	public BeroepsTaakDto find(int activiteitId, int architectuurLaagId, int niveau) {
		BeroepsTaak beroepsTaak = beroepsTaakDao.find(activiteitId, architectuurLaagId, niveau);
		return Domain2DtoMapper.map(beroepsTaak);
	}


}
