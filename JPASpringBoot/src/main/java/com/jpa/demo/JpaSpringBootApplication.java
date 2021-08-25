package com.jpa.demo;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.jpa.demo.dao.StudentRepository;
import com.jpa.demo.entity.Student;

@SpringBootApplication
public class JpaSpringBootApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(JpaSpringBootApplication.class, args);

		StudentRepository repository = context.getBean(StudentRepository.class);
		/*
		 * Save One Record In the Database 
		 * Student s1 = new Student();
		 * s1.setAddress("Umerkot"); s1.setName("Jai Kumar");
		 * s1.setRollNumber("2K19/AA/23"); Student s = repository.save(s1);
		 * System.out.println("Student : " + s);
		 */
		/*
		 * Save More than One Record In the Database 
		 * List<Student> students =
		 * List.of(s1,s2);
		 * 
		 * Iterable<Student> saveAll = repository.saveAll(students);
		 * 
		 * saveAll.forEach(student->{ System.out.println(student); });
		 * System.out.println("Successfully Done"); //Student s1 = repository.save(s);
		 * //System.out.println("Student : " + s1);
		 */
		/*
		 * Update The Student Record 
		 * Optional<Student> optional =
		 * repository.findById(2); Student s = optional.get();
		 * s.setName("Naresh Kumar");
		 * 
		 * Student student = repository.save(s); System.out.println(student);
		 * System.out.println("Updated Successfully");
		 */
		/*
		 * Get All Record From Database Method1 
		 * Iterable<Student> getAll =
		 * repository.findAll();
		 * 
		 * Iterator<Student> iterator = getAll.iterator();
		 * 
		 * while(iterator.hasNext()) { Student s = iterator.next();
		 * System.out.println(s); }
		 */
		/*
		 * Get All Record From Database Method2 
		 * Iterable<Student> iterable =
		 * repository.findAll(); iterable.forEach(user->{System.out.println(user);});
		 */
		/*
		 * Delete the Record By Id 
		 * repository.deleteById(2);
		 * System.out.println("Deleted Successfully");
		 */

		/*
		 * Delete All The Record From Database 
		 * Iterable<Student> iterable =
		 * repository.findAll();
		 * 
		 * iterable.forEach(student->{System.out.println(student);});
		 * 
		 * repository.deleteAll(iterable);
		 * 
		 * System.out.println("Successfully Delete The All Record From Database");
		 */
	}

}
