package com.example.JavaTask.controller;


import com.example.JavaTask.DTOs.EmployeeDto;
import com.example.JavaTask.DTOs.RolesDTO;
import com.example.JavaTask.REPO.DepartmentsREPO;
import com.example.JavaTask.REPO.EmployeeREPO;
import com.example.JavaTask.REPO.RolesREPO;
import com.example.JavaTask.Service.Imp.EmployeeServiceImp;
import com.example.JavaTask.exception.NotFoundException;
import com.example.JavaTask.model.Employee;
import com.example.JavaTask.model.Phones;
import com.example.JavaTask.model.RequestDto;
import com.example.JavaTask.model.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeServiceImp employeeServiceImp;
    @Autowired
    private EmployeeREPO employeeREPO;
    @Autowired
    private DepartmentsREPO departmentsREPO;
    @Autowired
    private RolesREPO rolesREPO;


//    @PostMapping("addEmployee") // CreateEmployee	   Done  Deprecated
//    public Employee addEmployee(@RequestBody EmployeeDto requestDto){
//        return  employeeServiceImp.CreateEmployee(requestDto);
//    }
                ///////////////Employee/////////////////////
    @PostMapping("/addEmployee")  //addEmployee  Done
    public Employee addRoleTOEmp(@RequestBody RequestDto requestDto){
        Employee employee = new Employee();

        employee.setName(requestDto.getName());
        employee.setDepartment(requestDto.getDepartment());
        for(RolesDTO dto : requestDto.getRoles()){
            employee.addRole(castRole(dto));
        }
        for(Phones phone : requestDto.getPhones()){
            employee.addPhone(phone);
        }
        return employeeREPO.save(employee);
    }


    @GetMapping("{employeeId}")  //GetEmployeeById  Done
    public Employee getEmployee(@PathVariable Long employeeId){
        return employeeREPO.findById(employeeId)
                .orElseThrow(() -> new NotFoundException("Employee Not Found"));
    }

    @PutMapping("/{employeeId}") //update employee
    public Employee Update(@PathVariable Long employeeId, @RequestBody RequestDto requestDto){
        Employee updateEmployee = employeeREPO.findById(employeeId)
                .orElseThrow(() -> new NotFoundException("Employee Not Found"));
        updateEmployee.setName(requestDto.getName());
        updateEmployee.setDepartment(requestDto.getDepartment());
        for(RolesDTO dto : requestDto.getRoles()){
            updateEmployee.addRole(castRole(dto));
        }
        for(Phones phone : requestDto.getPhones()){
            updateEmployee.addPhone(phone);
        }
        return employeeREPO.save(updateEmployee);
    }
            /////////////////////End Of Employee///////////////////////


/////////////////////Employee with Departments///////////

    @GetMapping("/department/{departmentId}/employees") //Done   GetEmployeesByDepartmentId
    public List<Employee> getEmployeeByDepartment(@PathVariable Long departmentId){
        if(!departmentsREPO.existsById(departmentId)){
            throw new NotFoundException("Department Not Found");
        }
        return employeeREPO.findByDepartmentId(departmentId);
    }

    @PostMapping("/department/{departmentId}/addEmployee") //Done
    public Employee addEmployee(@PathVariable Long departmentId,
                                @RequestBody Employee employeeReq){
        return departmentsREPO.findById(departmentId).map(department -> {
            employeeReq.setDepartment(department);
            return employeeREPO.save(employeeReq);
        }).orElseThrow(() -> new NotFoundException("Department Not Found"));
    }


/////////////////////Employee with Roles///////////


    @GetMapping("/role/{roleId}/employees") //GetEmployeesInRole Done
    public List<Employee> getEmployeeByRole(@PathVariable Long roleId){
        if(!rolesREPO.existsById(roleId)){
            throw new NotFoundException("Role Not Found");
        }
        return employeeREPO.findByRolesId(roleId);
    }


    @PutMapping("/{employeeId}/role/{roleId}") //update employee role
    public Employee addRoleToEmployee(@PathVariable Long employeeId,
                                      @PathVariable Long roleId){
        return employeeServiceImp.assignRoleToEmployee(employeeId,roleId);
    }


    @PostMapping("{employeeId}/addEmployeeWithRoles")  //AssignNewRolesToEmployee  Done
    public Employee addNewRoleTOEmp(@PathVariable Long employeeId,@RequestBody RequestDto requestDto){
        Employee employee = employeeREPO.findById(employeeId).get();

        for(RolesDTO dto : requestDto.getRoles()){
            employee.addRole(castRole(dto));
        }
        return employeeREPO.save(employee);
    }

    private Roles castRole(RolesDTO dto) {
        Roles rolesObj = new Roles();

        rolesObj.setCode(dto.getCode());
        return  rolesObj;
    }

/////////////////////Employee Phones ////////

    @PostMapping("{employeeId}/addEmployeeWithPhones")  //AddPhoneNumbersToEmployee   Done
    public Employee addNewPhonesTOEmp(@PathVariable Long employeeId,@RequestBody RequestDto requestDto){
        Employee employee = employeeREPO.findById(employeeId).get();

        for(Phones phone : requestDto.getPhones()){
            employee.addPhone(phone);
        }
        return employeeREPO.save(employee);
    }

    @DeleteMapping("/deleteEmployeePhone/{employeeId}/phone/{phoneId}")   //DeletePhoneNumber   Done
    public Employee deleteEmployee(@PathVariable Long employeeId
            , @PathVariable Long phoneId) {
        return employeeServiceImp.deleteEmployeePhone(employeeId,phoneId);
    }

}
