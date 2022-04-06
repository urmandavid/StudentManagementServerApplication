package se.yrgo.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import se.yrgo.dataaccess.StudentDataAccess;
import se.yrgo.dataaccess.StudentNotFoundException;
import se.yrgo.domain.Student;

@Stateless
public class StudentManagementImplementation implements StudentManagementService {
    /**
     * This class is an implementation of the StudentManagementService interface.
     * We override methods from that interface in this class (with dao).
     *
     * We @Inject to make a connection to our (DAO) StudentDataAccess-interface.
     *
     * We use @Stateless because this is an EJB-class.
     */

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
    public Student getById(int id) throws StudentNotFoundException {
        return dao.findById(id);
    }

    @Override
    public void updateStudent(int id, String program, int academicYear) throws StudentNotFoundException {
        dao.updateStudent(id, program, academicYear);
    }

    @Override
    public void deleteStudent(int id) throws StudentNotFoundException {
        dao.deleteStudent(id);
    }

}
