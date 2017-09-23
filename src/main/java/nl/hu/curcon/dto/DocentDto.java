package nl.hu.curcon.dto;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by jayfeurich on 25/06/15.
 */
@XmlRootElement
public class DocentDto extends HRefDto {
    private int id;
    private String naam;
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

	@Override
	public String toString() {
		return "DocentDto [id=" + id + ", naam=" + naam + "]";
	}
}
