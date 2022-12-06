package com.example.JavaTask.controller;


import com.example.JavaTask.DTOs.DepartmentDto;
import com.example.JavaTask.REPO.DepartmentsREPO;
import com.example.JavaTask.Service.Imp.DepartmentServiceImp;
import com.example.JavaTask.model.Departments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentServiceImp departmentServiceImp;

    @Autowired
    private DepartmentsREPO departmentsREPO;

    @PostMapping("/add_Dept")       //Done  <><><><
    public Departments addDepartment(@RequestBody Departments departmentReq){
        return departmentsREPO.save(departmentReq);
    }

}
