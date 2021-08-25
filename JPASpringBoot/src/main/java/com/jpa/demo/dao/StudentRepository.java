package com.jpa.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.jpa.demo.entity.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {
	public List<Student> findByName(String name);

	public List<Student> findByRollNumber(String rollNumber);

	public List<Student> findByAddress(String address);

	public List<Student> findByNameAndRollNumber(String name, String rollNumber);

	@Query("select s from Student s")
	public List<Student> getAllStudent();

	@Query("select s from Student s where s.name =:n")
	public List<Student> getStudentByName(@Param("n") String name);

	@Query("select s from Student s where s.name =:n and s.rollNumber =:r")
	public List<Student> getStudentByNameAndRollNumber(@Param("n") String name, @Param("r") String rollNumber);

	@Query(value = "select * from student", nativeQuery = true)
	public List<Student> getStudents();
}
