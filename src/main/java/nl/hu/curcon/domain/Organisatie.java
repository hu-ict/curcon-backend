package nl.hu.curcon.domain;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
@Table(name = "organisatie")
@Entity
public class Organisatie implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	@Column(name = "naam")
	private String naam;
	@OneToMany(mappedBy = "organisatie")
	private List<Docent> docenten;
	@OneToMany(mappedBy = "organisatie")
	private List<OpleidingsProfiel> opleidingsProfielen;
	@OneToMany(mappedBy = "organisatie")
	List<Cursus> cursussen;
	@OneToMany
	private List<BeroepsTaak> alleBeroepsTaken;
	@OneToMany
	private List<ProfessionalSkill> professionalSkills;

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

	public List<Docent> getDocenten() {
		return docenten;
	}

	public void setDocenten(List<Docent> docenten) {
		this.docenten = docenten;
	}

	public List<BeroepsTaak> getAlleBeroepsTaken() {
		return alleBeroepsTaken;
	}

	public void setAlleBeroepsTaken(List<BeroepsTaak> alleBeroepsTaken) {
		this.alleBeroepsTaken = alleBeroepsTaken;
	}

	public List<ProfessionalSkill> getProfessionalSkills() {
		return professionalSkills;
	}

	public void setProfessionalSkills(List<ProfessionalSkill> professionalSkills) {
		this.professionalSkills = professionalSkills;
	}

	public List<Cursus> getCursussen() {
		return cursussen;
	}

	public void setcursussen(List<Cursus> alleCursussen) {
		this.cursussen = alleCursussen;
	}

	public List<OpleidingsProfiel> getOpleidingsProfielen() {
		return opleidingsProfielen;
	}

	public void setOpleidingsProfielen(List<OpleidingsProfiel> opleidingsProfielen) {
		this.opleidingsProfielen = opleidingsProfielen;
	}
}
