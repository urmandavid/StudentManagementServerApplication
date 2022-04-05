package se.yrgo.dataaccess;

import java.util.List;

import se.yrgo.domain.Student;

import javax.ejb.Local;

@Local
public interface StudentDataAccess {

    public  void insert(Student newStudent);

    public  List<Student> findAll();

    public  List<Student> findBySurname(String surname);

    public Student findById(int id);

}
