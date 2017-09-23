package nl.hu.curcon.dto;

/**
 * Created by jayfeurich on 25/06/15.
 */
public class ProfessionalSkillDto extends HRefDto {
    private int id;
    private String code;
    private String beschrijving;
    private String niveau;

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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getBeschrijving() {
		return beschrijving;
	}

	public void setBeschrijving(String beschrijving) {
		this.beschrijving = beschrijving;
	}
}
