package se.yrgo.rest;

import se.yrgo.domain.Student;
import se.yrgo.service.StudentManagementService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.List;

@Stateless
@Path("/students")
public class StudentResource {

    @Inject
    private StudentManagementService service;

    @GET
    @Produces("application/JSON")
    public List<Student> getAllStudents() {
        return service.getAllStudents();
    }

    @GET
    @Produces("application/JSON")
    @Path("{studentNo}")
    public Student findStudentById(@PathParam("studentNo") int id) {
        return service.getById(id);
    }

    @POST
    @Produces("application/JSON")
    @Consumes("application/JSON")
    public Student createStudent(Student student) {
        service.registerStudent(student);
        return student;
    }

}
