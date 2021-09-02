package com.school.myschool.controller;

import com.school.myschool.Services.service;
import com.school.myschool.entity.AffectationEleve;
import com.school.myschool.entity.Eleve;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class AffectationEleveController {
    service service;
    @Autowired
    public AffectationEleveController(service service1) {
        service = service1;
    }




}
