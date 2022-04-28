package com.school.myschool.controller;

import com.school.myschool.Services.ClasseService;
import com.school.myschool.Services.EnseignantService;
import com.school.myschool.Services.MatiereService;
import com.school.myschool.Services.service;
import com.school.myschool.entity.Classe;
import com.school.myschool.entity.Eleve;
import com.school.myschool.entity.Matiere;
import com.school.myschool.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RequestMapping("/Enseignant")
@Controller
public class EnseignantController {
    EnseignantService service;
    MatiereService ServiceMatiere;
    ClasseService ServiceClasse;
    @Autowired
    public EnseignantController(EnseignantService service1,MatiereService ServiceMatiere1,  ClasseService ClasseService1) {
        ServiceClasse=ClasseService1;
        ServiceMatiere=ServiceMatiere1;
        service = service1;
    }
    @GetMapping("/")
    public String findAll(Model theModel) {
        List<User> list= service.findAll();
        theModel.addAttribute("list",list);
        // get customers from the service
        return "/Enseignant/listEnseignant";
    }
    @GetMapping("/addEnseignant")
    public String showFormForAdd(Model theModel) {

        // create model attribute to bind form data
        User theEnseignant = new User();
        theModel.addAttribute("Enseignant", theEnseignant);
        return "Enseignant/addEnseignant";
    }
    @GetMapping("/EmploiEnseignant")
    public String showFormForEmploi(@RequestParam("EnseignantID") int theId,Model theModel) {
        List<Matiere> listMatiere =ServiceMatiere.findAll();
        List<Classe> listClasse =ServiceClasse.findAll();

        // create model attribute to bind form data
        User theEnseignant= service.findById(theId);
        theModel.addAttribute("listMatiere", listMatiere);
        theModel.addAttribute("listClasse", listClasse);
        theModel.addAttribute("Enseignant", theEnseignant);
        return "Emploi/listEmploi";
    }
    @PostMapping("/save")
    public String saveEmployee( @ModelAttribute("Enseignant") User theEnseignant) {
        // save the employee
        service.save(theEnseignant);
        // use a redirect to prevent duplicate submissions
        return "redirect:/Enseignant/";
    }
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("EnseignantID") int theId,
                                    Model theModel) {
        // get the employee from the service
        User theEnseignant= service.findById(theId);
        // set employee as a model attribute to pre-populate the form
        theModel.addAttribute("Enseignant", theEnseignant);
        // send over to our form
        return "Enseignant/addEnseignant";
    }
    @GetMapping("deleteEnseignant")
    public String delete(@RequestParam("EnseignantID") int theId) {
        // delete the employee
        service.deleteById(theId);
        // redirect to /employees/list
        return "redirect:/Enseignant/";

    }
    @GetMapping("/emploi")
    public String showEmploi(Model theModel, Principal principal) {
        List<Classe> listClasse =ServiceClasse.findAll();

        // create model attribute to bind form data
        String name=principal.getName();
        User theEnseignant= service.findbyname(principal.getName());
        theModel.addAttribute("Enseignant", theEnseignant);
        return "Emploi";
    }
}
