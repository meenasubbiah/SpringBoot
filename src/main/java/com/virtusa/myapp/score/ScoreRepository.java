package com.virtusa.myapp.score;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface ScoreRepository extends CrudRepository<Score,Integer>{

	public List<Score> findByStudentId(int studentid);
	public List<Score> findByName(String subjectName);
	public Score findByStudentIdAndName( int studentid,String subjectName);
	public void deleteScoreByStudentId(int studentid);
}
