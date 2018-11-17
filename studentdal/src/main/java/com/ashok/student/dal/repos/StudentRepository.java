package com.ashok.student.dal.repos;

import org.springframework.data.repository.CrudRepository;

import com.ashok.student.dal.entities.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

}
