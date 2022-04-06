package se.yrgo.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;

@Entity
public class Student implements Serializable {
    /**
     * Our class Student is used when creating Student objects.
     * The class contains fields corresponding to each student.
     *
     * It also contains Getters, Setters and a toString-method.
     * The class implements java.io.Serializable.
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String firstName;
    private String surname;
    private String program;
    private int academicYear;

    public Student() {}

    public Student(String firstName, String surname, String program, int academicYear) {
        this.firstName = firstName;
        this.surname = surname;
        this.program = program;
        this.academicYear = academicYear;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public int getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(int academicYear) {
        this.academicYear = academicYear;
    }

    public String toString() {
        return "Student: " + this.firstName + " " + this.surname;
    }
}
