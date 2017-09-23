package nl.hu.curcon.dto;

/**
 * Created by jayfeurich on 25/06/15.
 */
public class OsirisResultaatTypeDto {
    private int id;
    private String naam;
    private String omschrijving;

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
