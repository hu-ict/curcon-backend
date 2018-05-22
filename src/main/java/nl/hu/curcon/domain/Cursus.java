package nl.hu.curcon.domain;

import javax.persistence.*;

import nl.hu.curcon.domain.hboi.BeroepsTaak;

import java.io.Serializable;
import java.util.List;

/**
 * @author berend.wilkens, 2 mei 2017
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "cursus")
public class Cursus implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	@Column(name = "cursuscode")
	private String cursusCode;
	@Column(name = "naam")
	private String naam;
	@Column(name = "ects")
	private int europeanCredits;
	@Column(name = "periode")
	private int periode;
	@ManyToOne
	@JoinColumn(name = "organisatie_id")
	private Organisatie organisatie;
	@ManyToOne
	@JoinColumn(name = "docent_id")
	private Docent cursuscoordinator;
	@ManyToMany
	private List<Trefwoord> trefwoorden;
	@OneToMany(mappedBy = "cursus")
	private List<Leerdoel> leerdoelen;
	@OneToMany(mappedBy = "cursus")
	private List<Toets> toetsen;
	
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

	public String getCursusCode() {
		return cursusCode;
	}

	public void setCursusCode(String cursusCode) {
		this.cursusCode = cursusCode;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public int getEuropeanCredits() {
		return europeanCredits;
	}

	public void setEuropeanCredits(int europeanCredits) {
		this.europeanCredits = europeanCredits;
	}

	public Docent getCursuscoordinator() {
		return cursuscoordinator;
	}

	public void setCursuscoordinator(Docent cursuscoordinator) {
		this.cursuscoordinator = cursuscoordinator;
	}

	public List<Trefwoord> getTrefwoorden() {
		return trefwoorden;
	}

	public void setTrefwoorden(List<Trefwoord> trefwoorden) {
		this.trefwoorden = trefwoorden;
	}

	public List<Leerdoel> getLeerdoelen() {
		return leerdoelen;
	}

	public void setLeerdoelen(List<Leerdoel> leerdoelen) {
		this.leerdoelen = leerdoelen;
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

	public int getPeriode() {
		return periode;
	}

	public void setPeriode(int periode) {
		this.periode = periode;
	}

	public Organisatie getOrganisatie() {
		return organisatie;
	}

	public void setOrganisatie(Organisatie organisatie) {
		this.organisatie = organisatie;
	}
	public List<Toets> getToetsen() {
		return toetsen;
	}

	public void setToetsen(List<Toets> toetsen) {
		this.toetsen = toetsen;
	}

}