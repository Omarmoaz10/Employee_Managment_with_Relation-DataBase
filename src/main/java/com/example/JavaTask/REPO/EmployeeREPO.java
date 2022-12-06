package com.example.JavaTask.REPO;

import com.example.JavaTask.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EmployeeREPO extends JpaRepository<Employee,Long> {
    List<Employee> findByDepartmentId(Long departmentId);

    List<Employee> findByName(String name);


    List<Employee> findByRolesId(Long roleId);
}
