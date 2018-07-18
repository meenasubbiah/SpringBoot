package com.virtusa.myapp.students;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.virtusa.myapp.score.Score;

@Entity
public class Student {
	
	@Id 
	@GeneratedValue()
	private int id;
	
	@Column(name="Student_Name")
	private String name;
	
	@OneToMany(mappedBy="student")
	private List<Score>  scores;
	
	
	public Student() {
		super();
	}
	public Student(int id, String name, List<Score>  scores) {
		super();
		this.id = id;
		this.name = name;
	//	this.scores = scores;
	}
	/*public List<Score> getScores() {
		return scores;
	}
	public void setScores(List<Score>  scores) {
		this.scores = scores;
	}*/
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
	@Override
	public String toString() {
		return "Students [id=" + id + ", name=" + name + "]";
	}
	

}
