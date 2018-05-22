package nl.hu.curcon.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author berend.wilkens
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="docent")
public class Docent implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	private String naam;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "organisatie_id", nullable = false)
	private Organisatie organisatie;

	public Docent(String naam) {
		this.naam = naam;
	}

	public Docent() {
	}

	@Column(name="naam")
	public String getNaam() {

		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Organisatie getOrganisatie() {
		return organisatie;
	}

	public void setOrganisatie(Organisatie organisatie) {
		this.organisatie = organisatie;
	}

}
