package com.school.myschool.controller;

import com.school.myschool.Services.service;
import com.school.myschool.entity.Eleve;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class cc {
    service service;
    @Autowired
    public cc(service service1) {
        service = service1;
    }
    @GetMapping("/Eleve/showemploi")
    public String showemploi() {

        return "Emploi/listEmploi";
    }
    @GetMapping("/")
    public String findAll(Model theModel) {
        List<Eleve> list= service.findAll();
        theModel.addAttribute("list",list);
        // get customers from the service
        return "/Eleve/listEleve";
    }

    @GetMapping("/Eleve/addEleve")
    public String showFormForAdd(Model theModel) {

        // create model attribute to bind form data
        Eleve theEleve = new Eleve();
        theModel.addAttribute("Eleve", theEleve);
        return "Eleve/addEleve";
    }
    @PostMapping("/Eleve/save")
    public String saveEmployee( @ModelAttribute("Eleve") Eleve theEleve) {

        // save the employee
        service.save(theEleve);

        // use a redirect to prevent duplicate submissions
        return "redirect:/";
    }
    @GetMapping("/Eleve/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("EleveID") int theId,
                                    Model theModel) {

        // get the employee from the service
        Eleve theEleve= service.findById(theId);

        // set employee as a model attribute to pre-populate the form
        theModel.addAttribute("Eleve", theEleve);

        // send over to our form
        return "Eleve/addEleve";
    }
    @GetMapping("/Eleve/deleteEleve")
    public String delete(@RequestParam("EleveID") int theId) {
        // delete the employee
        service.deleteById(theId);
        // redirect to /employees/list
        return "redirect:/";

    }


}
