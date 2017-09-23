package nl.hu.curcon.dto;

/**
 * Created by jayfeurich on 25/06/15.
 */
public class BloomNiveauDto extends HRefDto{
    private int id;
    private String niveau;
    private String omschrijving;

    public void setId(int id) {
        this.id = id;
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
}
