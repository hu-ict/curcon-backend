package nl.hu.curcon.domain;

import javax.persistence.*;

import java.io.Serializable;

/**
 * @author berend.wilkens, 24 mrt. 2017
 * ToetsElement
 */
@SuppressWarnings("serial")
@Entity
@Table(name="toetselement")
public class ToetsElement implements Serializable {
    @Id
    @Column
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    @Column
    private double gewicht;
    @ManyToOne()
	@JoinColumn(name = "beoordelingselement_id")
    private BeoordelingsElement beoordelingsElement;
    @ManyToOne
    @JoinColumn(name = "bloomniveau_id")
    private BloomNiveau bloomNiveau;
    @ManyToOne
	@JoinColumn(name = "leerdoel_id")
    private Leerdoel leerdoel;

    public Leerdoel getLeerdoel() {
        return leerdoel;
    }

    public void setLeerdoel(Leerdoel leerdoel) {
        this.leerdoel = leerdoel;
    }

    public BeoordelingsElement getBeoordelingsElement() {
        return beoordelingsElement;
    }

    public void setBeoordelingsElement(BeoordelingsElement beoordelingsElement) {
        this.beoordelingsElement = beoordelingsElement;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getGewicht() {
		return gewicht;
	}

	public void setGewicht(double gewicht) {
		this.gewicht = gewicht;
	}

	public BloomNiveau getBloomNiveau() {
		return bloomNiveau;
	}

	public void setBloomNiveau(BloomNiveau bloomNiveau) {
		this.bloomNiveau = bloomNiveau;
	}

}
