package nl.hu.curcon.domain;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Frits on 22-6-2015.
 */
@SuppressWarnings("serial")
@Entity
public class ToetsPlanning implements Serializable{
    @Id
    @Column
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    @OneToMany
    private List<ToetsElement> toetsElementen;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<ToetsElement> getToetsElementen() {
		return toetsElementen;
	}
	public void setToetsElementen(List<ToetsElement> toetsElementen) {
		this.toetsElementen = toetsElementen;
	}

}
