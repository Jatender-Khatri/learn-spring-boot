package com.jpa.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.jpa.demo.entity.Student;

public interface StudentRepository extends CrudRepository<Student, Integer>{

}
