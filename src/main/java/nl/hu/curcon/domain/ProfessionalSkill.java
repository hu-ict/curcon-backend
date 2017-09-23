package nl.hu.curcon.domain;

import javax.persistence.*;

import java.io.Serializable;

/**
 * @author berend.wilkens, 1 jun. 2017
 */
@SuppressWarnings("serial")
@Table(name="professionalskill")
@Entity
public class ProfessionalSkill implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	@Column(name="code")
	private String code;
	@Column(name="beschrijving", length = 1024)
	private String beschrijving;
	@Column(name="niveau")
	private String niveau;
	@ManyToOne
	@JoinColumn(name = "activiteit_id", nullable = false)
	private Activiteit activiteit;


	public String getNiveau() {
		return niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVerkort() {
		return getCode() + " - " + getNiveau();
	}

	public String getBeschrijving() {
		return beschrijving;
	}

	public void setBeschrijving(String beschrijving) {
		this.beschrijving = beschrijving;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Activiteit getActiviteit() {
		return activiteit;
	}

	public void setActiviteit(Activiteit activiteit) {
		this.activiteit = activiteit;
	}
}
