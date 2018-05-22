package nl.hu.curcon.dto.check;

import nl.hu.curcon.dto.HRefDto;
import nl.hu.curcon.dto.competence.BeroepsTaakDto;

public class EctsBeroepsTaakDto extends HRefDto {
	private BeroepsTaakDto beroepsTaak;
	private double ects = 0.0;

	public void addEcts(double ects) {
		this.ects += ects;
	}

	public BeroepsTaakDto getBeroepsTaak() {
		return beroepsTaak;
	}

	public void setBeroepsTaak(BeroepsTaakDto beroepsTaak) {
		this.beroepsTaak = beroepsTaak;
	}

	public double getEcts() {
		return ects;
	}

	public void setEcts(double ects) {
		this.ects = ects;
	}

}
