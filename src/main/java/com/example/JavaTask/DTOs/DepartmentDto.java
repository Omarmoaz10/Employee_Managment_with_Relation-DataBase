package com.example.JavaTask.DTOs;

import com.example.JavaTask.model.Employee;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto {


    private Long id ;

    private  String name ;

    private String code ;

    private Set<Employee> employees;
}
