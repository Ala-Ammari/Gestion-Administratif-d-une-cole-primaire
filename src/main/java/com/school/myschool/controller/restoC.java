package com.school.myschool.controller;

import com.school.myschool.Services.ClasseService;
import com.school.myschool.Services.EmploiService;
import com.school.myschool.Services.EnseignantService;
import com.school.myschool.Services.MatiereService;
import com.school.myschool.entity.User;
import com.school.myschool.entity.emploi;
import com.school.myschool.entity.emploiEntity;
import com.school.myschool.entity.emploiRest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class restoC {
    EnseignantService service;
    MatiereService ServiceMatiere;
    ClasseService ServiceClasse;
    EmploiService ServiceEmploi;
    List<emploi> cust = new ArrayList<emploi>();

    public restoC(EnseignantService service, MatiereService serviceMatiere, ClasseService serviceClasse, EmploiService serviceEmploi1) {
        this.service = service;
        ServiceMatiere = serviceMatiere;
        ServiceClasse = serviceClasse;
        ServiceEmploi = serviceEmploi1;
    }

    @PostMapping(value="/save",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE )
    public @ResponseBody String postCustomer( emploi formCustomer){
        for (int i = 0; i <formCustomer.getHours().size() ; i++) {
            for (int j = 0; j <formCustomer.getDays().size() ; j++) {
                int idmat=Integer.parseInt(formCustomer.getMatiere());
                int idclasse=Integer.parseInt(formCustomer.getClasse());
                int idens=Integer.parseInt(formCustomer.getEnseignant());

                emploiEntity emploiEntity=new emploiEntity(ServiceMatiere.findById(idmat),
                        ServiceClasse.findById(idclasse),
                        service.findById(idens),
                        ServiceEmploi.findByhoraireId(Integer.parseInt(formCustomer.getHours().get(i))),
                        ServiceEmploi.findBydaysId(Integer.parseInt(formCustomer.getDays().get(j))));
                ServiceEmploi.save(emploiEntity);

            }

        }
        System.out.println("list of :::"+formCustomer);
        return "psst success";
    }

@GetMapping("/emploi/{id}")
    public List<emploiRest> find(@PathVariable Integer id) {
    System.out.println("id::: "+id);
    User enseignant=service.findById(id) ;
    List<emploiEntity> emploiEntity=ServiceEmploi.findByemploientity(enseignant);

    List<emploiRest>emploiRest=new ArrayList<>();
    for (int i = 0; i <emploiEntity.size() ; i++) {
        emploiRest emploi1=new emploiRest(emploiEntity.get(i).getMatiere().getMatiereName(),
                emploiEntity.get(i).getClasse().getClasseName(),
                emploiEntity.get(i).getEnseignant().getUserFName(),
                emploiEntity.get(i).getDays().getDayId()+"",
                emploiEntity.get(i).getHoraire().getId()+""
                );
        emploiRest.add(emploi1);
    }
    return emploiRest;
    }




}
