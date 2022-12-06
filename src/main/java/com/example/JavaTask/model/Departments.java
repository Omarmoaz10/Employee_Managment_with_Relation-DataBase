package com.example.JavaTask.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Departments")
public class Departments  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;

    private  String name ;

    private String code ;

    @OneToMany(mappedBy = "department" , fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    @JsonIgnore
    private Set< Employee> employees;



}
