package nl.hu.curcon.domain.hboi;

import javax.persistence.*;

/**
 * @author berend.wilkens
 *
 */
@Table(name = "werkveld")
@Entity
public class Werkveld {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@ManyToOne
	@JoinColumn(name = "architectuurlaag_id", nullable = false)
	private Architectuurlaag architectuurlaag;
	@ManyToOne
	@JoinColumn(name = "activiteit_id", nullable = false)
	private Activiteit activiteit;

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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		Werkveld other = (Werkveld) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
