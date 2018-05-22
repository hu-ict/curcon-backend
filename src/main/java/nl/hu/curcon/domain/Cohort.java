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
import javax.persistence.Table;

/**
 * @author berend.wilkens, 20 apr. 2017
 * Cohort
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "cohort")
public class Cohort implements Serializable {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "jaar")
	private String jaar;
	@ManyToOne
	@JoinColumn(name="opleidingsProfiel_id")
	private OpleidingsProfiel opleidingsProfiel;
	@ManyToMany
	private List<Cursus> cursussen;

	public Cohort() {
	}

	public String getJaar() {
		return jaar;
	}

	public void setJaar(String jaar) {
		this.jaar = jaar;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the opleidingsProfiel
	 */
	public OpleidingsProfiel getOpleidingsProfiel() {
		return opleidingsProfiel;
	}

	/**
	 * @param opleidingsProfiel
	 *            the opleidingsProfiel to set
	 */
	public void setOpleidingsProfiel(OpleidingsProfiel opleidingsProfiel) {
		this.opleidingsProfiel = opleidingsProfiel;
	}

	public List<Cursus> getCursussen() {
		return cursussen;
	}

	public void setCursussen(List<Cursus> cursussen) {
		this.cursussen = cursussen;
	}

}
