package com.luv2codeinspring.cruddemo.dao;

import com.luv2codeinspring.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao{

    EntityManager entityManager;

    @Autowired
    public StudentDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student student) {
        // Implementation to save the student to the database
        entityManager.persist(student);
    }

    @Override
    public Student findById(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAllStudentsSortedByLastName() {
        TypedQuery<Student> query = entityManager.createQuery("SELECT s FROM Student s ORDER BY s.lastName", Student.class);
        List<Student> students = query.getResultList();
        return students;
    }

    @Override
    @Transactional
    public void updateStudent(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void deleteStudent(int id) {
        Student student = findById(id);
        entityManager.remove(student);
    }

    @Override
    @Transactional
    public int deleteAllStudents() {
        int numRowsDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();
        return numRowsDeleted;
    }
}
