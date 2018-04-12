package nl.hu.curcon.dtomapper;

import org.springframework.stereotype.Component;

import nl.hu.curcon.domain.BeoordelingsElement;
import nl.hu.curcon.domain.BloomNiveau;
import nl.hu.curcon.domain.Cohort;
import nl.hu.curcon.domain.Cursus;
import nl.hu.curcon.domain.Docent;
import nl.hu.curcon.domain.Leerdoel;
import nl.hu.curcon.domain.Leerlijn;
import nl.hu.curcon.domain.MillerNiveau;
import nl.hu.curcon.domain.OpleidingsProfiel;
import nl.hu.curcon.domain.Organisatie;
import nl.hu.curcon.domain.ProfessionalSkill;
import nl.hu.curcon.domain.Toets;
import nl.hu.curcon.domain.ToetsElement;
import nl.hu.curcon.domain.Trefwoord;
import nl.hu.curcon.domain.User;
import nl.hu.curcon.domain.hboi.BeroepsTaak;
import nl.hu.curcon.rest.MyApplication;

/**
 * @author berend.wilkens
 *
 */
@Component
public class Domain2DtoMapperHRef {

	public static String mapHRef(BeoordelingsElement domain) {
		if (domain == null) {return null;}
		return MyApplication.getBaseUrl() + "beoordelingselementen/" + domain.getId();
	}

	public static String mapHRef(BeroepsTaak domain) {
		if (domain == null) {return null;}
		return MyApplication.getBaseUrl() + "beroepstaken/" + domain.getId();
	}

	public static String mapHRef(BloomNiveau domain) {
		if (domain == null) {return null;}
		return MyApplication.getBaseUrl() + "bloomniveaus/" + domain.getId();
	}

	public static String mapHRef(Cohort domain) {
		if (domain == null) {return null;}
		return MyApplication.getBaseUrl() + "cohorten/" + domain.getId();
	}

	public static String mapHRef(Cursus domain) {
		if (domain == null) {return null;}
		return MyApplication.getBaseUrl() + "cursussen/" + domain.getId();
	}

	public static String mapHRef(Docent domain) {
		if (domain == null) {return null;}
		return MyApplication.getBaseUrl() + "docenten/" + domain.getId();
	}

	public static String mapHRef(Leerdoel domain) {
		if (domain == null) {return null;}
		return MyApplication.getBaseUrl() + "leerdoelen/" + domain.getId();
	}

	public static String mapHRef(MillerNiveau millerNiveau) {
		return MyApplication.BASE_URL + "millerniveaus/" + millerNiveau.getId();
	}

	public static String mapHRef(OpleidingsProfiel domain) {
		if (domain == null) {return null;}
		return MyApplication.getBaseUrl() + "opleidingsprofielen/" + domain.getId();
	}

	public static String mapHRef(Organisatie domain) {
		if (domain == null) {return null;}
		return MyApplication.getBaseUrl() + "organisaties/" + domain.getId();
	}

	public static String mapHRef(ProfessionalSkill domain) {
		if (domain == null) {return null;}
		return MyApplication.getBaseUrl() + "professionalskills/" + domain.getId();
	}

	public static String mapHRef(Toets domain) {
		if (domain == null) {return null;}
		return MyApplication.getBaseUrl() + "toetsen/" + domain.getId();
	}

	public static String mapHRef(ToetsElement domain) {
		if (domain == null) {return null;}
		return MyApplication.getBaseUrl() + "toetselementen/" + domain.getId();
	}

	public static String mapHRef(Trefwoord domain) {
		if (domain == null) {return null;}
		return MyApplication.getBaseUrl() + "trefwoorden/" + domain.getId();
	}

	public static String mapHRef(Leerlijn domain) {
		if (domain == null) {return null;}
		return MyApplication.getBaseUrl() + "leerlijnen/" + domain.getId();
	}
	
	public static String mapHRef(User domain) {
		if (domain == null) {return null;}
		return MyApplication.getBaseUrl() + "gebruikers/" + domain.getUsername();
	}


}
