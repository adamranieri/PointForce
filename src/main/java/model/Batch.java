package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Batch {

	@Id
	@GeneratedValue
	private int id;
	private String name;

	
	@OneToOne
	private Trainer trainer;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Associate> associates;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Trainer getTrainer() {
		return trainer;
	}
	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}
	public List<Associate> getAssociates() {
		return associates;
	}
	public void setAssociates(List<Associate> associates) {
		this.associates = associates;
	}
	
	
	
	
}
