package nl.hu.curcon.dto.check;

import nl.hu.curcon.dto.BeroepsTaakDto;
import nl.hu.curcon.dto.HRefDto;

public class ConformiteitBeroepsTaakDto extends HRefDto {
	private BeroepsTaakDto beroepsTaak;
	private int conformiteit = 0;
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

}
