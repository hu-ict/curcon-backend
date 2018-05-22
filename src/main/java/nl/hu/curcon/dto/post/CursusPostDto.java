package nl.hu.curcon.dto.post;

/**
 * @author berend.wilkens, 3 mei 2017
 */
public class CursusPostDto {
    private String code;
    private String naam;
    private int periode;
    private int europeanCredits;
    private int coordinator;
	public int getEuropeanCredits() {
		return europeanCredits;
	}
	public void setEuropeanCredits(int europeanCredits) {
		this.europeanCredits = europeanCredits;
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
	public int getPeriode() {
		return periode;
	}
	public void setPeriode(int periode) {
		this.periode = periode;
	}
	public int getCoordinator() {
		return coordinator;
	}
	public void setCoordinator(int coordinator) {
		this.coordinator = coordinator;
	}
    
}