package com.school.myschool.controller;

import com.school.myschool.Services.MatiereService;

import com.school.myschool.entity.Matiere;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/Matiere")
@Controller
public class MatiereController {
    MatiereService service;
    @Autowired
    public MatiereController(MatiereService service1) {
        service = service1;
    }

    @GetMapping("/")
    public String findAll(Model theModel) {
        List<Matiere> list= service.findAll();
        theModel.addAttribute("list",list);
        // get customers from the service
        return "/Matiere/listMatiere";
    }

    @GetMapping("/addMatiere")
    public String showFormForAdd(Model theModel) {

        // create model attribute to bind form data
        Matiere theMatiere = new Matiere();
        theModel.addAttribute("Matiere", theMatiere);
        return "Matiere/addMatiere";
    }
    @PostMapping("/save")
    public String save( @ModelAttribute("Maiere") Matiere theMatiere) {

        // save the Matiere
        service.save(theMatiere);

        // use a redirect to prevent duplicate submissions
        return "redirect:/Matiere/";
    }
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("MatiereID") int theId,
                                    Model theModel) {

        // get the Matiere from the service
        Matiere theMatiere= service.findById(theId);

        // set employee as a model attribute to pre-populate the form
        theModel.addAttribute("Matiere", theMatiere);

        // send over to our form
        return "Matiere/addMatiere";
    }
    @GetMapping("/deleteMatiere")
    public String delete(@RequestParam("MatiereID") int theId) {
        // delete the Matiere
        service.deleteById(theId);
        // redirect to /Matieres/list
        return "redirect:/";

    }
}