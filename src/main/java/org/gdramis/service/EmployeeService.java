package org.gdramis.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.gdramis.model.Employee;


@ApplicationScoped
public class EmployeeService {
    
    @Inject
    EntityManager em;

    @Transactional 
    public void createEmployee(String name, String surname) {
        Employee employee = new Employee();
        employee.setName(name);
        employee.setSurname(surname);
        em.persist(employee);
    }

    @Transactional 
    public Employee getEmployee(Integer id) {
        return em.find(Employee.class, id);
    }

    @Transactional 
    public List<Employee> getAllEmployee() {
        TypedQuery<Employee> query = em.createNamedQuery("findAllEmployee", Employee.class);
        return query.getResultList();
    }


}
