package com.example.JavaTask.controller;

import com.example.JavaTask.REPO.RolesREPO;
import com.example.JavaTask.model.Departments;
import com.example.JavaTask.model.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    RolesREPO rolesREPO;


    @PostMapping("/addRole")   //CreateRole     done
    public Roles addRole(@RequestBody Roles rolesReq){
        return rolesREPO.save(rolesReq);
    }



}
