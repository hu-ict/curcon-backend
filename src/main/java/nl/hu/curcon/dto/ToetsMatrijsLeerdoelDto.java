package nl.hu.curcon.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author berend.wilkens
 *
 */
@XmlRootElement
public class ToetsMatrijsLeerdoelDto extends HRefDto {
	private int id;
	private String omschrijving;
	private LinkDto eindBT;
	private LinkDto eindPS;
	private LinkDto bloomniveau;
	private List<ToetsMatrijsToetsElementDto> toetsElementen;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOmschrijving() {
		return omschrijving;
	}

	public void setOmschrijving(String omschrijving) {
		this.omschrijving = omschrijving;
	}

	public LinkDto getEindBT() {
		return eindBT;
	}

	public void setEindBT(LinkDto eindBT) {
		this.eindBT = eindBT;
	}

	public LinkDto getEindPS() {
		return eindPS;
	}

	public void setEindPS(LinkDto eindPS) {
		this.eindPS = eindPS;
	}

	public LinkDto getBloomniveau() {
		return bloomniveau;
	}

	public void setBloomniveau(LinkDto bloomniveau) {
		this.bloomniveau = bloomniveau;
	}

	public List<ToetsMatrijsToetsElementDto> getToetsElementen() {
		return toetsElementen;
	}

	public void setToetsElementen(List<ToetsMatrijsToetsElementDto> toetsElementen) {
		this.toetsElementen = toetsElementen;
	}

}
