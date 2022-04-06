package se.yrgo.dataaccess;

import se.yrgo.domain.Student;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.persistence.PersistenceContext;
import javax.persistence.NoResultException;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Stateless
@Default
public class StudentDataAccessProductionVersion implements StudentDataAccess {
    /**
     * This ProductionVersion implements the interface StudentDataAccess.
     * We have overridden methods from that interface.
     * The methods contain queries to our database.
     *
     * We use @Stateless because this is an EJB-class.
     * We use @Default because this is the Default -> ProductionVersion.
     * (The TestingVersion will be using the @Alternative-annotation).
     */

    @PersistenceContext
    private EntityManager em;

    @Override
    public void insert(Student newStudent) {
        em.persist(newStudent);
    }

    @Override
    public List<Student> findAll() {
        Query q = em.createQuery("select student from Student student");
        List<Student> students = q.getResultList();
        return students;
    }

    @Override
    public List<Student> findBySurname(String surname) {
        Query q = em.createQuery("select student from Student student where student.surname = :surname");
        q.setParameter("surname", surname);
        return q.getResultList();
    }

    @Override
    public Student findById(int id) throws StudentNotFoundException {
        Query q = em.createQuery("select student from Student student where student.id = :id");
        q.setParameter("id", id);
        try {
            return (Student) q.getSingleResult();
        } catch (NoResultException e) {
            throw new StudentNotFoundException();
        }
    }

    @Override
    public void updateStudent(int id, String program, int academicYear) throws StudentNotFoundException {
        Student s = findById(id);
        s.setProgram(program);
        s.setAcademicYear(academicYear);
    }

    @Override
    public void deleteStudent(int id) throws StudentNotFoundException {
        Student s = findById(id);
        em.remove(s);
    }

}
