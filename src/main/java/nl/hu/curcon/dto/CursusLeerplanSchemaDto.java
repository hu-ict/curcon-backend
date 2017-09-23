package nl.hu.curcon.dto;

import java.util.List;

/**
 * @author berend.wilkens, 24 mrt. 2017
 * CursusLeerplanSchemaDto
 */
public class CursusLeerplanSchemaDto extends HRefDto {
    private int id;
    private String code;
    private String naam;
    private int periode;
    private int europeanCredits;
    private List<LinkDto> eindBT;
    private List<LinkDto> eindPS;
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
	public int getPeriode() {
		return periode;
	}
	public void setPeriode(int periode) {
		this.periode = periode;
	}
	public List<LinkDto> getEindBT() {
		return eindBT;
	}
	public void setEindBT(List<LinkDto> eindBT) {
		this.eindBT = eindBT;
	}
	public List<LinkDto> getEindPS() {
		return eindPS;
	}
	public void setEindPS(List<LinkDto> eindPS) {
		this.eindPS = eindPS;
	}
}
