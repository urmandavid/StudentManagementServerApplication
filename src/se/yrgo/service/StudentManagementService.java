package se.yrgo.service;

import se.yrgo.dataaccess.StudentNotFoundException;
import se.yrgo.domain.Student;

import javax.ejb.Local;
import java.util.List;

@Local
public interface StudentManagementService {
    /**
     * This StudentManagementService-interface serves as a bridge between our Server- and Client-code.
     */

    public void registerStudent(Student student);

    public List<Student> getAllStudents ();

    public List<Student>searchBySurname(String surname);

    public Student getById(int id) throws StudentNotFoundException;

    public void updateStudent(int id, String program, int academicYear) throws StudentNotFoundException;

    public void deleteStudent(int id) throws StudentNotFoundException;

}
