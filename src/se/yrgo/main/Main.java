package se.yrgo.main;

import se.yrgo.domain.Student;
import se.yrgo.service.StudentManagementImplementation;
import se.yrgo.service.StudentManagementService;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        StudentManagementService service = new StudentManagementImplementation();

        List<Student> students = service.getAllStudents();
        for (Student student : students) {
            System.out.println(student);
        }
    }

}
