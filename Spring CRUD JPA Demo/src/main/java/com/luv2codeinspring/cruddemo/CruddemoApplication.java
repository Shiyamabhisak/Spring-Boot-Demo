package com.luv2codeinspring.cruddemo;

import com.luv2codeinspring.cruddemo.dao.StudentDao;
import com.luv2codeinspring.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication(
		scanBasePackages = "com.luv2codeinspring.cruddemo, com.luv2codeinspring.dao, com.luv2codeinspring.entity"
)
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDao studentDao) {
		return runner -> {

			createStudent(studentDao);

//			readStudent(studentDao);

			readAllStudents(studentDao);

//			updateStudent(studentDao);

//			deleteStudent(studentDao);

//			deleteAllStudents(studentDao);
		};
	}

	private void createStudent(StudentDao studentDao){
		System.out.println("Creating new student object...");
		Student student1 = new Student("Shiyamabhisak", "N V", "Shiyamabhisak235@gmail.com");
		Student student2 = new Student("Monkey D", "Luffy", "onepiece@gmail.com");

		System.out.println("Saving student: " + student1);
		studentDao.save(student1);
		System.out.println("Saving student: " + student2);
		studentDao.save(student2);

		System.out.println("saved Student. Generated id: " + student1.getId());
		System.out.println("saved Student. Generated id: " + student2.getId());
	}

	private void readStudent(StudentDao studentDao){
		System.out.println("Creating new student object...");
		Student student = new Student("Shiyamabhisak", "N V", "Shiyamabhisak235@gmail.com");

		System.out.println("Saving student: " + student);
		studentDao.save(student);

		System.out.println("Finding student with id: " + student.getId());
		Student resultStudent = studentDao.findById(student.getId());

		System.out.println("Found student: " + resultStudent);
		System.out.println("Done!");
	}

	private void readAllStudents(StudentDao studentDao){
		System.out.println("Finding all students...");
		List<Student> students = studentDao.findAllStudentsSortedByLastName();
		for (Student student : students) {
			System.out.println(student);
		}
		System.out.println("Done!");
	}

	private void updateStudent(StudentDao studentDAO) {
		// retrieve student based on the id: primary key
		int studentId = 1;
		System.out.println("Getting student with id: " + studentId);
		Student myStudent = studentDAO.findById(studentId);
		System.out.println("Updating student...");
		// change first name to "Scooby"
		myStudent.setFirstName("Shiyam");
		myStudent.setLastName("Abhisak N V");
		studentDAO.updateStudent(myStudent);
		// display updated student
		System.out.println("Updated student: " + myStudent);
	}

	private void deleteStudent(StudentDao studentDAO) {
		int studentId = 1;
		System.out.println("Deleting student with id: " + studentId);
		studentDAO.deleteStudent(studentId);
		System.out.println("Deleted student with id: " + studentId);
	}

	private int deleteAllStudents(StudentDao studentDAO) {
		System.out.println("Deleting all students...");
		int numRowsDeleted = studentDAO.deleteAllStudents();
		System.out.println("Deleted rows: " + numRowsDeleted);
		return numRowsDeleted;
	}
}
