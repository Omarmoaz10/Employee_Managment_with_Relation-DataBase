package com.example.JavaTask.model;

import com.example.JavaTask.DTOs.RolesDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestDto {

    private String name ;
    private Set<RolesDTO> roles =new HashSet<>();
    private Departments department;
    private Set<Phones> phones = new HashSet<>();
}
