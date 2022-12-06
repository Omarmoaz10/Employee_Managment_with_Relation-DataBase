package com.example.JavaTask.Service.Imp;

import com.example.JavaTask.DTOs.EmployeeDto;
import com.example.JavaTask.DTOs.RolesDTO;
import com.example.JavaTask.REPO.EmployeeREPO;
import com.example.JavaTask.REPO.PhonesREPO;
import com.example.JavaTask.REPO.RolesREPO;
import com.example.JavaTask.Service.EmployeeService;
import com.example.JavaTask.model.Employee;
import com.example.JavaTask.model.Phones;
import com.example.JavaTask.model.RequestDto;
import com.example.JavaTask.model.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class EmployeeServiceImp implements EmployeeService {

    @Autowired
    private EmployeeREPO employeeREPO;

    @Autowired
   private RolesREPO rolesREPO;

    @Autowired
    private PhonesREPO phonesREPO;

    @Override
    public Employee CreateEmployee(EmployeeDto employeeDto) {
        Employee newEmployee = new Employee();

        newEmployee.setName(employeeDto.getName());

        employeeREPO.save(newEmployee);

        return newEmployee;
    }

    public Employee assignRoleToEmployee(Long employeeId, Long roleId) {
        Set<Roles> rolesSet= null;

        Employee employee = employeeREPO.findById(employeeId).get();
        Roles roles = rolesREPO.findById(roleId).get();

        rolesSet = employee.getRoles();
        rolesSet.add(roles);
        employee.setRoles(rolesSet);

        return employeeREPO.save(employee);
    }


    public Employee deleteEmployeePhone(Long employeeId , Long phoneId) {
        Set<Phones> phoneSet= null;

        Employee employee = employeeREPO.findById(employeeId).get();
        Phones phone = phonesREPO.findById(phoneId).get();

        phoneSet = employee.getEmployeePhones();
        phoneSet.remove(phone);
        phonesREPO.deleteById(phoneId);
        employee.setEmployeePhones(phoneSet);

        return employeeREPO.save(employee);
    }


}
