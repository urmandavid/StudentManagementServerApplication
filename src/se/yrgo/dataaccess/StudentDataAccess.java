package se.yrgo.dataaccess;

import se.yrgo.domain.Student;

import javax.ejb.Local;
import java.util.List;

@Local
public interface StudentDataAccess {
    /**
     * This interface is a @Local EJB-class.
     * We add a Data Access Object-layer to our project.
     *
     * Our ProductionVersion- and TestingVersion-classes implements this interface.
     */

    public void insert(Student newStudent);

    public List<Student> findAll();

    public List<Student> findBySurname(String surname);

    public Student findById(int id) throws StudentNotFoundException;

    public void updateStudent(int id, String program, int academicYear) throws StudentNotFoundException;

    public void deleteStudent(int id) throws StudentNotFoundException;



}
