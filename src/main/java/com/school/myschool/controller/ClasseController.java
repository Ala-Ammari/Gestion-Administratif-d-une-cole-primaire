package com.school.myschool.controller;

import com.school.myschool.Services.ClasseService;
import com.school.myschool.entity.Classe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/Classe")
@Controller
public class ClasseController {
    ClasseService service;
    @Autowired
    public ClasseController(ClasseService service1) {
        service = service1;
    }

    @GetMapping("/")
    public String findAll(Model theModel) {
        List<Classe> list= service.findAll();
        theModel.addAttribute("list",list);
        // get customers from the service
        return "/Classe/listClasse";
    }

    @GetMapping("/addClasse")
    public String showFormForAdd(Model theModel) {

        // create model attribute to bind form data
        Classe theClasse = new Classe();
        theModel.addAttribute("Classe", theClasse);
        return "/Classe/addClasse";
    }
    @PostMapping("/save")
    public String saveClasse( @ModelAttribute("Classe") Classe theClasse) {

        // save the Classe
        service.save(theClasse);

        // use a redirect to prevent duplicate submissions
        return "redirect:/Classe/";
    }
    @GetMapping("showFormForUpdate")
    public String showFormForUpdate(@RequestParam("ClasseID") int theId,
                                    Model theModel) {

        // get the classe from the service
        Classe theClasse= service.findById(theId);

        // set Classe as a model attribute to pre-populate the form
        theModel.addAttribute("Classe", theClasse);

        // send over to our form
        return "/Classe/addClasse";
    }
    @GetMapping("deleteClasse")
    public String delete(@RequestParam("ClasseID") int theId) {
        // delete the Classe
        service.deleteById(theId);
        // redirect to /Classe/list
        return "redirect:/Classe/";

    }
}