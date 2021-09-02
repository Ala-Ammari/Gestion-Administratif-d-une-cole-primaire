package com.school.myschool.Services;
import com.school.myschool.dao.dao_implementaion;
import com.school.myschool.entity.Eleve;
import com.school.myschool.entity.Matiere;
import com.school.myschool.entity.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class MatiereService {
    private dao_implementaion dao;
    @Autowired
    public MatiereService(dao_implementaion dao) {
        this.dao = dao;
    }
    @Transactional
    public  List<Matiere> findAll() {
        return dao.findAllMatiere();
    }
    @Transactional
    public void  save(Matiere matiere) {
        dao.saveMatiere(matiere);
    }
    @Transactional
    public Matiere  findById(int theId) {
        return dao.findMatiereById(theId);
    }
    @Transactional
    public void  deleteById(int theId) {
        dao.deleteMatiereById(theId);
    }
}
