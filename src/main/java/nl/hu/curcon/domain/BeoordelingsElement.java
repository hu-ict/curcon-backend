package nl.hu.curcon.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
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
 * @author berend.wilkens, 24 mrt. 2017
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "beoordelingselement")
public class BeoordelingsElement implements Serializable {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column
	private String naam;
	@Column
	private String omschrijving;
	@Column
	private int gewicht;
	@ManyToOne
	@JoinColumn(name = "toets_id")
	private Toets toets;
	@OneToMany(mappedBy = "beoordelingsElement", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	private List<ToetsElement> toetsElementen;

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

	public String getOmschrijving() {
		return omschrijving;
	}

	public void setOmschrijving(String omschrijving) {
		this.omschrijving = omschrijving;
	}

	public Toets getToets() {
		return toets;
	}

	public void setToets(Toets toets) {
		this.toets = toets;
	}

	public List<ToetsElement> getToetsElementen() {
		return toetsElementen;
	}

	public void setToetsElementen(List<ToetsElement> toetsElementen) {
		this.toetsElementen = toetsElementen;
	}

	public int getGewicht() {
		return gewicht;
	}

	public void setGewicht(int gewicht) {
		this.gewicht = gewicht;
	}

}
