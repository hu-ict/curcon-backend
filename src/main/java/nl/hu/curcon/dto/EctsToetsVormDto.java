package nl.hu.curcon.dto;

public class EctsToetsVormDto extends HRefDto {
	private BeroepsTaakDto beroepsTaak;
	private double wetenEcts = 0.0;
	private double toepassenEcts = 0.0;
	private double tonenEcts = 0.0;
	private double doenEcts = 0.0;
	
	public void addTonenEcts(double tonenEcts) {
		this.tonenEcts += tonenEcts;
	}
	public void addDoenEcts(double doenEcts) {
		this.doenEcts += doenEcts;
	}
	public void addWetenEcts(double wetenEcts) {
		this.wetenEcts += wetenEcts;
	}
	public void addToepassenEcts(double toepassenEcts) {
		this.toepassenEcts += toepassenEcts;
	}

	public BeroepsTaakDto getBeroepsTaak() {
		return beroepsTaak;
	}
	public void setBeroepsTaak(BeroepsTaakDto beroepsTaak) {
		this.beroepsTaak = beroepsTaak;
	}
	public double getWetenEcts() {
		return wetenEcts;
	}
	public void setWetenEcts(double wetenEcts) {
		this.wetenEcts = wetenEcts;
	}
	public double getToepassenEcts() {
		return toepassenEcts;
	}
	public void setToepassenEcts(double toepassenEcts) {
		this.toepassenEcts = toepassenEcts;
	}
	public double getDoenEcts() {
		return doenEcts;
	}
	public void setDoenEcts(double doenEcts) {
		this.doenEcts = doenEcts;
	}

	public double getTonenEcts() {
		return tonenEcts;
	}
	public void setTonenEcts(double tonenEcts) {
		this.tonenEcts = tonenEcts;
	}


}
