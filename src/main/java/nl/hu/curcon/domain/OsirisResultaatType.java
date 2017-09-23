package nl.hu.curcon.domain;

import javax.persistence.*;

import java.io.Serializable;

/**
 * @author berend.wilkens, 3 mei 2017
 */
@SuppressWarnings("serial")
@Entity
@Table(name="osirisresultaattype")
public class OsirisResultaatType implements Serializable {
    @Id
    @Column
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    @Column
    private String naam;
    @Column
    private String omschrijving;

    public OsirisResultaatType(){}

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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
