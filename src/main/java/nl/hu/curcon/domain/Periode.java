package nl.hu.curcon.domain;

import javax.persistence.*;
import java.io.Serializable;
/**
 * @author berend.wilkens, 10 apr. 2017
 */
@Entity
@Table(name="periode")
public class Periode implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private int periode;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPeriode() {
		return periode;
	}

	public void setPeriode(int periode) {
		this.periode = periode;
	}

}
