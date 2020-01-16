/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.solent.com504.project.impl.dao.jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.solent.com504.project.model.dao.PersonDAO;
import org.solent.com504.project.model.dto.Person;
import org.solent.com504.project.model.dto.Role;

/**
 *
 * @author cgallen
 */
public class PersonDAOJpaImpl implements PersonDAO {

    final static Logger LOG = LogManager.getLogger(PersonDAOJpaImpl.class);

    private EntityManager entityManager;

    public PersonDAOJpaImpl(EntityManager em) {
        this.entityManager = em;
    }
//solent2Public/week9/webfacadeexample2-spring/dao-jpa/src/main/java/org/solent/com504/factoryandfacade/impl/dao/jpa/AnimalDaoJpaImpl.java
    @Override
    public Person findById(Long id) {
        Person person = entityManager.find(Person.class, id);
        return person;
    }

    @Override
    public Person save(Person person) {
        entityManager.getTransaction().begin();
        entityManager.persist(person);  // NOTE merge(animal) differnt semantics
        // entityManager.flush() could be used
        entityManager.getTransaction().commit();
        return person;
    }

    @Override
    public List<Person> findAll() {
        TypedQuery<Person> q = entityManager.createQuery("SELECT p FROM Person p", Person.class);
        List<Person> personList = q.getResultList();
        return personList;
    }

    @Override

    public boolean deleteById(long id) {
        Person temp = findById( id);
        if(temp ==null) return false;
        entityManager.getTransaction().begin();
        entityManager.remove(temp);
        entityManager.getTransaction().commit();
        return true;    
    }

    @Override
    public boolean delete(Person person) {
        if(person==null) return false;
        entityManager.remove(person);
        return true;
    }

    @Override
    public void deleteAll() {
        entityManager.getTransaction().begin();
        entityManager.createQuery("DELETE FROM Person ").executeUpdate();
        entityManager.getTransaction().commit();
    }

    @Override
    public List<Person> findByRole(Role role) {
        
        TypedQuery<Person> q=entityManager.createQuery("SELECT a FROM Person as a WHERE a.role = :role",Person.class);
                q.setParameter("role", role);

        return q.getResultList();
    }

    @Override
    public List<Person> findByName(String fName, String sName) {
        TypedQuery<Person> q=entityManager.createQuery("SELECT a FROM Person as a WHERE a.firstName = :fName AND a.secondName= :sName",Person.class);
        q.setParameter("fName", fName);
        q.setParameter("sName",sName);
        return q.getResultList();
    }

}
