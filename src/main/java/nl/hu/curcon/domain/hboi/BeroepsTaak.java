package nl.hu.curcon.domain.hboi;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author berend.wilkens, 29 jan. 2018
 *
 */
@Table(name="beroepstaak")
@Entity
public class BeroepsTaak {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@ManyToOne
	@JoinColumn(name = "architectuurlaag_id", nullable = false)
	private Architectuurlaag architectuurlaag;
	@ManyToOne
	@JoinColumn(name = "activiteit_id", nullable = false)
	private Activiteit activiteit;
	private int niveau;
	@Column(length = 1024)
	private String beschrijving;

	public int getNiveau() {
		return niveau;
	}

	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVerkort() {
		return activiteit.getNaam() + " - "	+ architectuurlaag.getNaam() + " - " + getNiveau();
	}

	public String getBeschrijving() {
		return beschrijving;
	}

	public void setBeschrijving(String beschrijving) {
		this.beschrijving = beschrijving;
	}

	public Architectuurlaag getArchitectuurlaag() {
		return architectuurlaag;
	}

	public void setArchitectuurlaag(Architectuurlaag architectuurlaag) {
		this.architectuurlaag = architectuurlaag;
	}

	public Activiteit getActiviteit() {
		return activiteit;
	}

	public void setActiviteit(Activiteit activiteit) {
		this.activiteit = activiteit;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BeroepsTaak other = (BeroepsTaak) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BeroepsTaak [id=" + id + ", architectuurlaag=" + architectuurlaag + ", activiteit=" + activiteit
				+ ", niveau=" + niveau + "]";
	}


}
