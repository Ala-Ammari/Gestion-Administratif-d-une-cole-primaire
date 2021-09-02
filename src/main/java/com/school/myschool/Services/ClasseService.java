package com.school.myschool.Services;

import com.school.myschool.dao.dao_implementaion;
import com.school.myschool.entity.Classe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class ClasseService {
    private dao_implementaion dao;
    @Autowired
    public ClasseService(dao_implementaion dao) {
        this.dao = dao;
    }
    @Transactional
    public List<Classe> findAll() {
        return dao.findAllClasse();
    }
    @Transactional
    public void  save(Classe classe) {
        dao.saveClasse(classe);
    }
    @Transactional
    public Classe  findById(int theId) {
        return dao.findClasseById(theId);
    }
    @Transactional
    public void  deleteById(int theId) {
        dao.deleteClasseById(theId);
    }
}