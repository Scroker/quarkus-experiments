package org.acme.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.acme.model.Employee;
import org.acme.service.EmployeeService;

@Path("api/employee")
public class EmployeeServiceRest {
    
    @Inject
    EmployeeService eservice;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("{id}")
    public String getEmployee(@PathParam("id") Integer id) {
        Employee employee = eservice.getEmployee(id);
        return employee.getName() + " " + employee.getSurname();
    }

}
