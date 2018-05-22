package nl.hu.curcon.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author berend.wilkens, 30 mei 2017
 */
@Entity
@Table(name = "trefwoord")
public class Trefwoord implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
    @Column
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    @Column
    private String naam;
    @Column
    private String omschrijving;
	@ManyToOne
	@JoinColumn(name = "leerlijn_id", nullable = false)
    private Leerlijn leerlijn;
    @OneToMany
    private List<Cursus> cursussen;
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
	public Leerlijn getLeerlijn() {
		return leerlijn;
	}
	public void setLeerlijn(Leerlijn leerlijn) {
		this.leerlijn = leerlijn;
	}
	public List<Cursus> getCursussen() {
		return cursussen;
	}
	public void setCursussen(List<Cursus> cursussen) {
		this.cursussen = cursussen;
	}
}
