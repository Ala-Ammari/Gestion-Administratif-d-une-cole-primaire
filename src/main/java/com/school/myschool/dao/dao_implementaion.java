package com.school.myschool.dao;

import com.school.myschool.entity.Eleve;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class dao_implementaion {

    // define field for entitymanager
    private EntityManager entityManager;

    // set up constructor injection
    @Autowired
    public dao_implementaion(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }



    public List<Eleve> findAll() {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // create a query
        Query<Eleve> theQuery =
                currentSession.createQuery("from Eleve", Eleve.class);

        // execute query and get result list
        List<Eleve> Eleve = theQuery.getResultList();

        // return the results
        return Eleve;
    }


    public Eleve findById(int theId) {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // get the employee
        Eleve Eleve =
                currentSession.get(Eleve.class, theId);

        // return the employee
        return Eleve;
    }


    public void save(Eleve theEmployee) {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // save employee
        currentSession.saveOrUpdate(theEmployee);
    }



    public void deleteById(int theId) {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // delete object with primary key
        Query theQuery =
                currentSession.createQuery(
                        "delete from Employee where id=:employeeId");
        theQuery.setParameter("employeeId", theId);

        theQuery.executeUpdate();
    }
}
