package com.example.JavaTask.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id  ;

    private String name ;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "department_ID" , nullable = true, referencedColumnName = "id")
//    @JsonIgnore
    private Departments department;


//    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)//fetch = FetchType.EAGER,cascade = CascadeType.ALL
    @JoinTable(name = "Employees_Roles",
            joinColumns = @JoinColumn(name = "employee_id" , referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id" , referencedColumnName = "id"))
    private Set<Roles> roles = new HashSet<>();

    public void addRole(Roles roles){
        this.roles.add(roles);
    }




    @OneToMany( fetch = FetchType.EAGER , cascade = CascadeType.ALL) //mappedBy = "employeeNumbers" ,
    @JoinColumn(name = "Employee_Phones" , referencedColumnName = "id")
    private Set<Phones> employeePhones= new HashSet<>();

    public void addPhone(Phones phone){
        this.employeePhones.add(phone);
    }
}
