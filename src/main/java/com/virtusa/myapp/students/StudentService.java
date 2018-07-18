package com.virtusa.myapp.students;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository repository;
	
	public List<Student> getStudents(){
		try{
			List<Student> students=new ArrayList<Student>();
			for(Student s : repository.findAll()){
				students.add(s);
		}
		return students;
	
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	/*private boolean getSpecificStudent(String id){
		int k=-1;
		Iterator<Students> i=students.iterator();
		while(i.hasNext()){
			k++;
			if(i.next().getId().equals(id)){
				//System.out.println(k);
				return (k);
				}
		}
		return -1;
		
		return repository.exists(id);
	}*/
	
	public Student getStudent(int id){
		try{
			return repository.findOne(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
		/*int index=getSpecificStudent(id);
		if(index==-1)
			return null;
		return students.get(index);*/
		
	}

	public void addStudent(Student student) {
		try{
			repository.save(student);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	public void updateStudent(Student student, int id) {
		try{
			if(repository.exists(id)){
				repository.save(student);	
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		/*  int index=getSpecificStudent(id);
		if(index==-1)
			return;
		students.set(index,student);*/
		/*repository.*/	
	}

	public void deleteStudent(int id) {
		try{
			if(repository.exists(id)){
				repository.delete(id);
			}	
		}catch(Exception e){
			e.printStackTrace();
		}	
	}
	
	

}
