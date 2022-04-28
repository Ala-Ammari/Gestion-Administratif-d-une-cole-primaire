package com.school.myschool.Services;

import com.school.myschool.dao.dao_implementaion;
import com.school.myschool.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class EmploiService {
    private dao_implementaion dao;
    @Autowired
    public EmploiService(dao_implementaion dao) {
        this.dao = dao;
    }
    @Transactional
    public List<emploiEntity> findAll() {
        return dao.findAllemploiEntity();
    }
    @Transactional
    public void  save(emploiEntity emploiEntity) {
        dao.saveemploiEntity(emploiEntity);
    }
    @Transactional
    public emploiEntity  findById(int theId) {
        return dao.findemploiEntityById(theId);
    }
    @Transactional
    public void  deleteById(int theId) {
        dao.deleteemploiEntityById(theId);
    }
    @Transactional
    public Horaire findByhoraireId(int theId) {
        return dao.findHoraireById(theId);
    }
    @Transactional
    public days findBydaysId(int theId) {
        return dao.finddayseById(theId);
    }
    @Transactional
    public List<emploiEntity> findByemploientity(User enseignant) {
        return dao.findAllemploiEntityById(enseignant);
    }
}
