package com.virtusa.myapp.score;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.virtusa.myapp.students.Student;

@Entity
public class Score {
	
	@Query(value="select s from score s where s.subject_name=:subname and s.student_id=:studentid")
	public List<Score> findByStudentIdAndName(@Param(value = "studentid") int studentid,@Param(value = "subname") String subjectName) {
		return null;
	}

	@Query(value="delete s from score s where s.student_id=:studentid")
	public void deleteScoreByStudentId(@Param(value = "studentid") int studentid) {
	}
	
	@Id
	@GeneratedValue 
	private int id;
	
	@Column(name="subject_name")
	private String name;
	
	@Column(name="mark")
	private int mark;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="student_id")
	private Student student;
	
	public Score() {
		super();
	}

	public Score(String name, int id, int mark) {
		super();
		this.name = name;
		this.id = id;
		this.mark = mark;
		
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}

	
	@Override
	public String toString() {
		return "Score [name=" + name + ", id=" + id + ", mark=" + mark
				+ "]";
	}
	

	

}
