package nl.hu.curcon.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author berend.wilkens, 23 mrt. 2017 ToetsMatrijsDto
 */
@XmlRootElement
public class ToetsMatrijsDto extends HRefDto {
	private int id;
	private String code;
	private String naam;
	private List<ToetsMatrijsLeerdoelDto> leerdoelen;
	private List<ToetsMatrijsToetsDto> toetsen;

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

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public List<ToetsMatrijsToetsDto> getToetsen() {
		return toetsen;
	}

	public void setToetsen(List<ToetsMatrijsToetsDto> toetsen) {
		this.toetsen = toetsen;
	}

	public List<ToetsMatrijsLeerdoelDto> getLeerdoelen() {
		return leerdoelen;
	}

	public void setLeerdoelen(List<ToetsMatrijsLeerdoelDto> leerdoelen) {
		this.leerdoelen = leerdoelen;
	}

}
