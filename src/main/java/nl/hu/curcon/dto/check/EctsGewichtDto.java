package nl.hu.curcon.dto.check;

import java.util.List;

import nl.hu.curcon.dto.HRefDto;
import nl.hu.curcon.dto.LinkDto;

public class EctsGewichtDto extends HRefDto {
	private LinkDto beroepsTaak;
	private List<EctsGewichtNiveauDto> niveaus;
	public LinkDto getBeroepsTaak() {
		return beroepsTaak;
	}
	public void setBeroepsTaak(LinkDto beroepsTaak) {
		this.beroepsTaak = beroepsTaak;
	}
	public List<EctsGewichtNiveauDto> getNiveaus() {
		return niveaus;
	}
	public void setNiveaus(List<EctsGewichtNiveauDto> niveaus) {
		this.niveaus = niveaus;
	}


}
