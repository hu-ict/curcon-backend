package nl.hu.curcon.domain.hboi;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;

/**
 * @author berend.wilkens, 31 mei 2017
 */
@SuppressWarnings("serial")
@Table(name="architectuurlaag")
@Entity
public class Architectuurlaag implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String naam;
	@Column(length = 1024)
	private String omschrijving;
	@OneToMany(mappedBy = "architectuurlaag")
	private List<BeroepsTaak> beroepstaken;
	public List<BeroepsTaak> getBeroepstaken() {
		return beroepstaken;
	}
	public void setBeroepstaken(List<BeroepsTaak> beroepstaken) {
		this.beroepstaken = beroepstaken;
	}
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
		return "Architectuurlaag [id=" + id + ", naam=" + naam + "]";
	}

}
