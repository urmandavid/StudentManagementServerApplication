package se.yrgo.dataaccess;

// OBS: TestingVersion!

import java.util.ArrayList;
import java.util.List;

import se.yrgo.domain.Student;

import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.persistence.Query;

@Stateless
@Alternative
public class StudentDataAccessTestingVersion implements StudentDataAccess {

    @Override
    public void insert(Student newStudent) {

    }
    @Override
    public List<Student> findAll() {
        // This is for the TestingVersion..
        Student stud1 = new Student("Stephen", "Hawkins", "Science", 2);
        Student stud2 = new Student("Jesper", "Stromblad", "Music", 3);
        Student stud3 = new Student("Lady", "Justinia", "Law", 4);
        Student stud4 = new Student("Anton", "Ranstad", "Esport", 5);

        List<Student> students = new ArrayList<Student>();
        students.add(stud1);
        students.add(stud2);
        students.add(stud3);
        students.add(stud4);
        return students;
    }

    @Override
    public List<Student> findBySurname(String surname) {
        return null;
    }

    @Override
    public Student findById(int id) {
        return null;
    }

}
