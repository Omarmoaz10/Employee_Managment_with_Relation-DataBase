package com.example.JavaTask.REPO;

import com.example.JavaTask.model.Phones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhonesREPO extends JpaRepository<Phones,Long> {
}
