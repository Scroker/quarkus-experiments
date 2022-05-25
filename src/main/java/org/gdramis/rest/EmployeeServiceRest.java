package org.gdramis.rest;

import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.gdramis.model.Employee;
import org.gdramis.service.EmployeeService;

@Path("api/employee")
public class EmployeeServiceRest {
    
    @Inject
    EmployeeService eservice;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Employee getEmployee(@PathParam("id") Integer id) {
        Employee employee = eservice.getEmployee(id);
        return employee;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Employee> getAllEmployee() {
        List<Employee> employeeList = eservice.getAllEmployee();
        return employeeList;
    }
}
