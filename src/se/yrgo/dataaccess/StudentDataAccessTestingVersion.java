package se.yrgo.dataaccess;

import se.yrgo.domain.Student;

import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import java.util.ArrayList;
import java.util.List;

@Stateless
@Alternative
public class StudentDataAccessTestingVersion implements StudentDataAccess {
    /**
     * This TestingVersion implements the interface StudentDataAccess.
     * We have overridden methods from that interface for testing purposes.
     *
     * We use @Stateless because this is an EJB-class.
     * We use @Alternative because this is the TestingVersion
     * (in contrast to the @Default-annotation in ProductionVersion).
     */

    @Override
    public void insert(Student newStudent) {

    }
    @Override
    public List<Student> findAll() {
        Student stud1 = new Student("Stephen", "Hawkins", "Science", 2);
        Student stud2 = new Student("Jesper", "Stromblad", "Music", 3);
        Student stud3 = new Student("Lady", "Justinia", "Law", 4);

        List<Student> students = new ArrayList<Student>();
        students.add(stud1);
        students.add(stud2);
        students.add(stud3);
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

    @Override
    public void updateStudent(int id, String program, int academicYear) throws StudentNotFoundException {

    }

    @Override
    public void deleteStudent(int id) throws StudentNotFoundException {

    }

}
