package se.yrgo.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import se.yrgo.dataaccess.StudentDataAccess;
import se.yrgo.domain.Student;

@Stateless
public class StudentManagementImplementation implements StudentManagementService {

    @Inject
    private StudentDataAccess dao;

    @Override
    public void registerStudent(Student student) {
        dao.insert(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return dao.findAll();
    }

    @Override
    public List<Student> searchBySurname(String surname) {
        return dao.findBySurname(surname);
    }

    @Override
    public Student getById(int id) {
        return dao.findById(id);
    }

}
