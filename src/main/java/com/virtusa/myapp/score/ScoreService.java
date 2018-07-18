package com.virtusa.myapp.score;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoreService {
	
	@Autowired
	ScoreRepository repository;
	List<Score> scores=new ArrayList<Score>();

	public List<Score> getAllScore(){
		
		try{
				scores.clear();
				for(Score s : repository.findAll()){
					scores.add(s);
			    }
				return scores;
		}
		catch(Exception e){
			 e.printStackTrace();
		 }
		return null;
	}
	
	public List<Score> getScoreByStudentId(int studentid){
		
		try{
			scores.clear();
			for(Score s : repository.findByStudentId(studentid)){
				scores.add(s);
			}
		return scores;
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Score> getScoreBySubjectName(String subjectName){
		try{
			scores.clear();
			for(Score s : repository.findByName(subjectName)){
				scores.add(s);
			}
			return scores;
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
		
	public void addScores(Score score) {
		 try{
			 repository.save(score);
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
	}
	
	public Score findByStudentIdAndName(int studentid,String subjectName) {
		try{
			return repository.findByStudentIdAndName(studentid, subjectName);
		
			}
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		return null;
	}
	
	public void deleteScoreByStudentId(int studentid) {
		try{
			repository.deleteScoreByStudentId(studentid);
		}
		catch(Exception e){
			e.printStackTrace();
		}			
	}
	public void updateScore(Score score) {
		
		try{
			if(repository.findByStudentIdAndName(score.getStudent().getId(),score.getName()) != null)
			repository.save(score);			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
}
