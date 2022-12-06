package com.example.JavaTask.Service.Imp;

import com.example.JavaTask.DTOs.DepartmentDto;
import com.example.JavaTask.REPO.DepartmentsREPO;
import com.example.JavaTask.Service.DepartmentService;
import com.example.JavaTask.model.Departments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImp implements DepartmentService {

    @Autowired
   private  DepartmentsREPO departmentsREPO;


    @Override
    public Departments createDepartment(DepartmentDto departmentDto) {
        Departments newDepartments = new Departments();

        newDepartments.setName(departmentDto.getName());
        newDepartments.setCode(departmentDto.getCode());
         newDepartments.setEmployees(departmentDto.getEmployees());

        departmentsREPO.save(newDepartments);

        return newDepartments;
    }
}
