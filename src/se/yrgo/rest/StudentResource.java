package se.yrgo.rest;

import se.yrgo.dataaccess.StudentNotFoundException;
import se.yrgo.domain.Student;
import se.yrgo.service.StudentManagementService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Stateless
@Path("/students")
public class StudentResource {
    /**
     * This is the resource class for our REST webservice.
     * It uses HTTP-methods to GET, POST, DELETE and PUT data.
     *
     * We @Inject to make a connection to our StudentManagementService-interface.
     *
     * We use @Stateless because this is an EJB-class.
     * We have a @Path("/students") on the class level.
     * We also define a @Path("{studentNo}") for our findStudentById-method.
     */

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
    public Response findStudentById(@PathParam("studentNo") int id) {
        try {
            Student result = service.getById(id);
            return Response.ok(result).build();
        } catch (StudentNotFoundException e) {
            return Response.status(404).build();
        }
    }

    @POST
    @Produces("application/JSON")
    @Consumes("application/JSON")
    public Student createStudent(Student student) {
        service.registerStudent(student);
        return student;
    }

    @DELETE
    @Path("{studentNo}")
    public Response deleteEmployee(@PathParam("studentNo") int id) {
        try {
            service.deleteStudent(id);
            return Response.status(204).build();
        } catch (StudentNotFoundException e) {
            return Response.status(404).build();
        }
    }

    @PUT
    @Path("{studentNo}")
    @Produces("application/JSON")
    @Consumes("application/JSON")
    public Response updateStudent(@PathParam("studentNo") int id, Student s) {
        try {
            service.updateStudent(id, s.getProgram(), s.getAcademicYear());
            return Response.ok(service.getById(id)).build();
        } catch (StudentNotFoundException e1) {
            return Response.status(404).build();
        }
    }

}
