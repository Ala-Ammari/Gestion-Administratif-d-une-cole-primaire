package com.school.myschool.Services;
import com.school.myschool.dao.dao_implementaion;
import com.school.myschool.entity.Eleve;
import com.school.myschool.entity.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class EnseignantService {
    private dao_implementaion dao;
    @Autowired
    public EnseignantService(dao_implementaion dao) {
        this.dao = dao;
    }
    @Transactional
    public  List<User> findAll() {
        return dao.findAllUser();
    }
    @Transactional
    public void  save(User enseignant) {
        dao.saveUser(enseignant);
    }
    @Transactional
    public User  findById(int theId) {
        return dao.findUserById(theId);
    }
    @Transactional
    public void  deleteById(int theId) {
        dao.deleteUserById(theId);
    }

}
