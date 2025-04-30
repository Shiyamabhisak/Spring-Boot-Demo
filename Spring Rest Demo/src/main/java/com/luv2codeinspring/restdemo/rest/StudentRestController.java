package com.luv2codeinspring.restdemo.rest;

import com.luv2codeinspring.restdemo.entity.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    List<Student> list;

    public StudentRestController(){
        list = new ArrayList<>();
        Student student1 = new Student("John", "Doe");
        Student student2 = new Student("Jane", "Doe");
        Student student3 = new Student("Jim", "Beam");
        Student student4 = new Student("Jack", "Daniels");
        list.add(student1);
        list.add(student2);
        list.add(student3);
        list.add(student4);
    }
    @GetMapping("/students")
    public List<Student> getStudents() {
        return list;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        if(studentId >= list.size() || studentId < 0) {
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }
        return list.get(studentId);
    }
}
