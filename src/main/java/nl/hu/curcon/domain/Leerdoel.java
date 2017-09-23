package nl.hu.curcon.domain;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;

/**
 * @author berend.wilkens, 16 jun. 2017
 */
@SuppressWarnings("serial")
@Table(name = "leerdoel")
@Entity
public class Leerdoel implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	@Column(name = "naam")
	private String naam;
	@Column(name = "omschrijving")
	private String omschrijving;
	@Column(name = "gewicht")
	private double gewicht;
	@ManyToOne
	@JoinColumn(name = "cursus_id", nullable = false)
	private Cursus cursus;
	@ManyToOne
	@JoinColumn(name = "beroepstaak_id", nullable = true)
	private BeroepsTaak beroepsTaak;
	@ManyToOne
	@JoinColumn(name = "professionalskill_id", nullable = true)
	private ProfessionalSkill professionalSkill;
	@ManyToOne
	@JoinColumn(name = "bloomniveau_id", nullable = false)
	private BloomNiveau bloomNiveau;
	@ManyToOne
	@JoinColumn(name = "trefwoord_id", nullable = true)
	private Trefwoord trefwoord;
	@OneToMany(mappedBy = "leerdoel", cascade=CascadeType.ALL)
	private List<ToetsElement> toetsElementen;

	public int getId() {
		return id;
	}

	public BeroepsTaak getBeroepsTaak() {
		return beroepsTaak;
	}

	public void setBeroepsTaak(BeroepsTaak beroepsTaak) {
		this.beroepsTaak = beroepsTaak;
	}

	public ProfessionalSkill getProfessionalSkill() {
		return professionalSkill;
	}

	public void setProfessionalSkill(ProfessionalSkill professionalSkill) {
		this.professionalSkill = professionalSkill;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOmschrijving() {
		return omschrijving;
	}

	public void setOmschrijving(String omschrijving) {
		this.omschrijving = omschrijving;
	}

	public BloomNiveau getBloomNiveau() {
		return bloomNiveau;
	}

	public void setBloomNiveau(BloomNiveau bloomNiveau) {
		this.bloomNiveau = bloomNiveau;
	}

	public Cursus getCursus() {
		return cursus;
	}

	public void setCursus(Cursus cursus) {
		this.cursus = cursus;
	}

	public List<ToetsElement> getToetsElementen() {
		return toetsElementen;
	}

	public void setToetsElementen(List<ToetsElement> toetsElementen) {
		this.toetsElementen = toetsElementen;
	}
	
	public Trefwoord getTrefwoord() {
		return trefwoord;
	}

	public void setTrefwoord(Trefwoord trefwoord) {
		this.trefwoord = trefwoord;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public double getGewicht() {
		return gewicht;
	}

	public void setGewicht(double gewicht) {
		this.gewicht = gewicht;
	}
}
