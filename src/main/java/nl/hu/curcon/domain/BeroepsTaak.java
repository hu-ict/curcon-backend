package nl.hu.curcon.domain;

import javax.persistence.*;

import java.io.Serializable;

/**
 * @author berend.wilkens, 31 mei 2017
 */
@SuppressWarnings("serial")
@Table(name="beroepstaak")
@Entity
public class BeroepsTaak implements Serializable {
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

	public static int detActiviteitId(String activiteit) {
		switch (activiteit) {
		case "Beheren":
			return 1;
		case "Analyseren":
			return 2;
		case "Adviseren":
			return 3;
		case "Ontwerpen":
			return 4;
		case "Realiseren":
			return 5;
		}
		return -1;
	}

	public static int detArchitectuurlaagId(String architectuurlaag) {
		switch (architectuurlaag) {
		case "Gebruikersinteractie":
			return 1;
		case "Bedrijfsprocessen":
			return 2;
		case "Infrastructuur":
			return 3;
		case "Software":
			return 4;
		case "Hardware Interfacing":
			return 5;
		}
		return -1;
	}

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
