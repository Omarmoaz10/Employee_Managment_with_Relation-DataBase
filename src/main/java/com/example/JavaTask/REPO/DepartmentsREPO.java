package com.example.JavaTask.REPO;

import com.example.JavaTask.model.Departments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentsREPO extends JpaRepository<Departments,Long> {
}
