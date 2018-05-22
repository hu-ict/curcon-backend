package nl.hu.curcon.dto;

/**
 * @author berend.wilkens
 *
 */
public class CohortDto extends HRefDto {
	private int id;
	private String jaar;
	private HRefDto cursussen;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getJaar() {
		return jaar;
	}

	public void setJaar(String jaar) {
		this.jaar = jaar;
	}

	public HRefDto getCursussen() {
		return cursussen;
	}

	public void setCursussen(HRefDto cursussen) {
		this.cursussen = cursussen;
	}

}
