package nl.hu.curcon.domain;

import javax.persistence.*;

import java.io.Serializable;
@SuppressWarnings("serial")
@Table(name="millerniveau")
@Entity
public class MillerNiveau implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String niveau;
    @Column
    private String omschrijving;

    public MillerNiveau() {
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
