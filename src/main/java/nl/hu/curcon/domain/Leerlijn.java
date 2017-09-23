package nl.hu.curcon.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author berend.wilkens, 10 apr. 2017
 */
@Entity
@Table(name = "leerlijn")
public class Leerlijn implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column
	private String naam;
	@Column
	private String omschrijving;
	@OneToMany(mappedBy = "leerlijn")
	private List<Trefwoord> trefwoorden;
	
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
	public List<Trefwoord> getTrefwoorden() {
		return trefwoorden;
	}
	public void setTrefwoorden(List<Trefwoord> trefwoorden) {
		this.trefwoorden = trefwoorden;
	}

}
