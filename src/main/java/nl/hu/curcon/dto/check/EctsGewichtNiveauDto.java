package nl.hu.curcon.dto.check;

public class EctsGewichtNiveauDto {
	private int niveau;
	private double cumulatiefEctsGewicht;
	public int getNiveau() {
		return niveau;
	}
	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}
	public double getCumulatiefEctsGewicht() {
		return cumulatiefEctsGewicht;
	}
	public void setCumulatiefEctsGewicht(double cumulatiefEctsGewicht) {
		this.cumulatiefEctsGewicht = cumulatiefEctsGewicht;
	}
	
	public void addEctsGewicht(double ectsGewicht) {
		cumulatiefEctsGewicht = cumulatiefEctsGewicht + ectsGewicht;
	}
}
