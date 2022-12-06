package com.example.JavaTask.Service;

import com.example.JavaTask.DTOs.DepartmentDto;
import com.example.JavaTask.model.Departments;

public interface DepartmentService {

    Departments createDepartment(DepartmentDto departmentDto);
}
