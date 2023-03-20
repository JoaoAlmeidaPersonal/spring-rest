package com.joaoalmeida.restapi.dao;

import com.joaoalmeida.restapi.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();
    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);

}
