package com.luv2codeinspring.cruddemo.dao;

import com.luv2codeinspring.cruddemo.entity.Student;
import java.util.List;

public interface StudentDao {
    void save(Student student);
    Student findById(int id);
    List<Student> findAllStudentsSortedByLastName();
    void updateStudent(Student student);
    void deleteStudent(int id);
    int deleteAllStudents();
}
