package se.yrgo.main;

import se.yrgo.domain.Student;
import se.yrgo.service.StudentManagementImplementation;
import se.yrgo.service.StudentManagementService;

import java.util.List;

public class Main {
    /**
     * This class and main-method was used before implementing DataAccessObjects and REST.
     */

    public static void main(String[] args) {
        StudentManagementService service = new StudentManagementImplementation();

        List<Student> students = service.getAllStudents();
        for (Student student : students) {
            System.out.println(student);
        }
    }

}
