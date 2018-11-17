package com.ashok.student.dal;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ashok.student.dal.entities.Student;
import com.ashok.student.dal.repos.StudentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentdalApplicationTests {

	@Autowired
	private StudentRepository _studentrep;
	@Test
	public void createStudent() {
		Student s = new Student();
		s.setName("Ashok");
		s.setCourse("Java REST");
		s.setFees(409.5d);
		
		_studentrep.save(s);
		
	}

	@Test
	public void DeleteStudentById() {
		Student s =new Student();
		s.setId(3l);
		_studentrep.delete(s);
	}
}
