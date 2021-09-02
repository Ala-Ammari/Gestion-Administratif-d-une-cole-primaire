package com.school.myschool.Services;

import com.school.myschool.dao.dao_implementaion;
import com.school.myschool.entity.Eleve;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class service {
    private dao_implementaion dao;
    @Autowired
    public service(dao_implementaion dao) {
        this.dao = dao;
    }
    @Transactional
    public  List<Eleve> findAll() {
        return dao.findAllEleve();
    }
    @Transactional
    public void  save(Eleve eleve) {
        dao.saveEleve(eleve);
    }
    @Transactional
    public Eleve  findById(int theId) {
       return dao.findEleveById(theId);
    }
    @Transactional
    public void  deleteById(int theId) {
        dao.deleteEleveById(theId);
    }


}
