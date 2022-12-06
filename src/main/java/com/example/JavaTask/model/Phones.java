package com.example.JavaTask.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "PhonesNumbers")
public class Phones {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id  ;

    private String number ;

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "employee_ID" , nullable = true, referencedColumnName = "id")
//    private Employee employeeNumbers;
}
