package nl.hu.curcon.dto;

/**
 * @author berend.wilkens, 24 mrt. 2017
 * CursusDto
 */
public class CursusDto extends HRefDto {
    private int id;
    private String code;
    private String naam;
    private int periode;
    private int europeanCredits;
    private LinkDto coordinator;
    private HRefDto eindBT;
    private HRefDto eindPS;
    private HRefDto leerdoelen;
    private HRefDto toetsen;
    
	public HRefDto getEindBT() {
		return eindBT;
	}
	public void setEindBT(HRefDto eindBT) {
		this.eindBT = eindBT;
	}
	public HRefDto getEindPS() {
		return eindPS;
	}
	public void setEindPS(HRefDto eindPS) {
		this.eindPS = eindPS;
	}
	public HRefDto getLeerdoelen() {
		return leerdoelen;
	}
	public void setLeerdoelen(HRefDto leerdoelen) {
		this.leerdoelen = leerdoelen;
	}
	public HRefDto getToetsen() {
		return toetsen;
	}
	public void setToetsen(HRefDto toetsen) {
		this.toetsen = toetsen;
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
	public String getNaam() {
		return naam;
	}
	public void setNaam(String naam) {
		this.naam = naam;
	}
	public int getEuropeanCredits() {
		return europeanCredits;
	}
	public void setEuropeanCredits(int europeanCredits) {
		this.europeanCredits = europeanCredits;
	}
	public LinkDto getCoordinator() {
		return coordinator;
	}
	public void setCoordinator(LinkDto coordinator) {
		this.coordinator = coordinator;
	}

	public int getPeriode() {
		return periode;
	}
	public void setPeriode(int periode) {
		this.periode = periode;
	}
}
