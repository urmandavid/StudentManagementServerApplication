package se.yrgo.service;

import se.yrgo.domain.Student;

import javax.ejb.Local;
import java.util.List;

@Local
public interface StudentManagementService {

    public void registerStudent(Student student);

    public List<Student> getAllStudents ();

    public List<Student>searchBySurname(String surname);

    public Student getById(int id);

}
