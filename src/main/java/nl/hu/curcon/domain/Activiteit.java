package nl.hu.curcon.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author berend.wilkens, 31 mei 2017
 */
@SuppressWarnings("serial")
@Table(name="activiteit")
@Entity
public class Activiteit implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String naam;
	@Column(length = 1024)
	private String omschrijving;
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
	@Override
	public String toString() {
		return "Activiteit [id=" + id + ", naam=" + naam + "]";
	}
}
