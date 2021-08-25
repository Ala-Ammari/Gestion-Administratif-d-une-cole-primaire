package com.school.myschool.controller;

import com.school.myschool.Services.service;
import com.school.myschool.entity.Eleve;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class cc {
    service service;
    @Autowired
    public cc(service service1) {
        service = service1;
    }

    @GetMapping("/")
    public List<Eleve> findAll() {
        Eleve eleve=new Eleve();
        eleve.setEleveFName("kf");
        eleve.setEleveLname("544");
        service.save(eleve);

        // get customers from the service
        return service.findAll() ;
    }

}
