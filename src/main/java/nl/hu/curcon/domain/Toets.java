package nl.hu.curcon.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author berend.wilkens
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "toets")
public class Toets implements Serializable {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column
	private String naam;
	@Column
	private double gewicht;
	@Column
	private String omschrijving;
	@ManyToOne
	@JoinColumn(name = "millerniveau_id")
	private MillerNiveau millerNiveau;
	@ManyToOne
	@JoinColumn(name = "cursus_id")
	private Cursus cursus;
	@OneToMany(mappedBy = "toets")
	private List<BeoordelingsElement> beoordelingsElementen;

	public Cursus getCursus() {
		return cursus;
	}

	public void setCursus(Cursus cursus) {
		this.cursus = cursus;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getGewicht() {
		return gewicht;
	}

	public void setGewicht(double gewicht) {
		this.gewicht = gewicht;
	}

	public List<BeoordelingsElement> getBeoordelingsElementen() {
		return beoordelingsElementen;
	}

	public void setBeoordelingsElementen(List<BeoordelingsElement> beoordelingsElementen) {
		this.beoordelingsElementen = beoordelingsElementen;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public MillerNiveau getMillerNiveau() {
		return millerNiveau;
	}

	public void setMillerNiveau(MillerNiveau millerNiveau) {
		this.millerNiveau = millerNiveau;
	}

	public String getOmschrijving() {
		return omschrijving;
	}

	public void setOmschrijving(String omschrijving) {
		this.omschrijving = omschrijving;
	}

}
