package nl.hu.curcon.dto.check;

import nl.hu.curcon.dto.HRefDto;
import nl.hu.curcon.dto.competence.BeroepsTaakDto;

public class ConformiteitBeroepsTaakDto extends HRefDto {
	private BeroepsTaakDto beroepsTaak;
	private int conformiteit = 0;
	private String opmerking;
	public BeroepsTaakDto getBeroepsTaak() {
		return beroepsTaak;
	}
	public void setBeroepsTaak(BeroepsTaakDto beroepsTaak) {
		this.beroepsTaak = beroepsTaak;
	}
	public int getConformiteit() {
		return conformiteit;
	}
	public void setConformiteit(int conformiteit) {
		this.conformiteit = conformiteit;
	}
	public String getOpmerking() {
		return opmerking;
	}
	public void setOpmerking(String opmerking) {
		this.opmerking = opmerking;
	}

}
