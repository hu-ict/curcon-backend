package nl.hu.curcon.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author berend.wilkens, 20 aug. 2017
 */
@SuppressWarnings("serial")
@Table(name = "opleidingsprofiel")
@Entity
public class OpleidingsProfiel implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	@Column(name = "naam")
	private String naam;
	@ManyToOne
	@JoinColumn(name = "organisatie_id")
	private Organisatie organisatie;
	@OneToMany(mappedBy = "opleidingsProfiel")
	private List<Cohort> cohorten;
	@OneToMany
	private List<Leerlijn> leerlijnen;
	@ManyToMany
	private List<BeroepsTaak> eindBTs;
	@ManyToMany
	private List<ProfessionalSkill> eindPSs;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public List<Leerlijn> getLeerlijnen() {
		return leerlijnen;
	}

	public void setLeerlijnen(List<Leerlijn> leerlijnen) {
		this.leerlijnen = leerlijnen;
	}

	public List<Cohort> getCohorten() {
		return cohorten;
	}

	public void setCohorten(List<Cohort> cohorten) {
		this.cohorten = cohorten;
	}

	public Organisatie getOrganisatie() {
		return organisatie;
	}

	public void setOrganisatie(Organisatie organisatie) {
		this.organisatie = organisatie;
	}

	public List<BeroepsTaak> getEindBTs() {
		return eindBTs;
	}

	public void setEindBTs(List<BeroepsTaak> eindBTs) {
		this.eindBTs = eindBTs;
	}

	public List<ProfessionalSkill> getEindPSs() {
		return eindPSs;
	}

	public void setEindPSs(List<ProfessionalSkill> eindPSs) {
		this.eindPSs = eindPSs;
	}
}
