package com.ai.jwd48.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ai.jwd48.model.Student;
import com.ai.jwd48.repo.StudentRepo;

@Service
public class StudentService {

	public List<Student> findAllStudent() {
		StudentRepo repo = new StudentRepo();
		List<Student> students = repo.findAllStudent(); //students can change to anyname you want but if u do you need to return the same name you change
		return students;
	}

	public Student findStudentById(int id) {
		StudentRepo repo = new StudentRepo();
		return repo.findStudentById(id);
	}

	public int saveStudent(Student student) {
	    StudentRepo repo = new StudentRepo();
	    return repo.saveStudent(student);
	}


	public int update(Student student) {
		StudentRepo repo = new StudentRepo();
		return repo.update(student);
	}

	public int delete(int id) {
		StudentRepo repo = new StudentRepo();
		return repo.delete(id);

	}

}