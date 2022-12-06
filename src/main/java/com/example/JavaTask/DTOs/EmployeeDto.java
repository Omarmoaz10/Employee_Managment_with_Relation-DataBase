package com.example.JavaTask.DTOs;

import com.example.JavaTask.model.Departments;
//import com.example.JavaTask.model.Phones;
import com.example.JavaTask.model.Roles;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

    private Long id  ;

    private String name ;

//    private Departments department;
////
////    private Set<Phones> employeePhones;
////
//    private Set<Roles> roles = new HashSet<>();
}
