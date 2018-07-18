/*package com.virtusa.myapp.score;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.virtusa.myapp.score.Score;


public class ScoreRepositoryImpl implements ScoreRepositoryCustomMethod{

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Score> findByStudentIdAndName(int studentid,String subjectName) {
		return this.entityManager.
				createQuery("select s from Score s where s.student_id='"+studentid+"' and s.subject_name like '"+subjectName+"'").
					getResultList();
	}

}*/



