/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.solent.com504.project.impl.dao.jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.solent.com504.project.model.dao.AppointmentDAO;
import org.solent.com504.project.model.dto.Appointment;
import org.solent.com504.project.model.dto.Person;

/**
 *
 * @author cgallen
 */
public class AppointmentDAOJpaImpl implements AppointmentDAO {

    final static Logger LOG = LogManager.getLogger(PersonDAOJpaImpl.class);

    private EntityManager entityManager;

    public AppointmentDAOJpaImpl(EntityManager em) {
        this.entityManager = em;
    }

    @Override
    public Appointment findById(Long id) {
        Appointment appointment = entityManager.find(Appointment.class, id);
        return appointment;
    }

    @Override
    public Appointment save(Appointment appointment) {
        entityManager.getTransaction().begin();
        entityManager.persist(appointment);  // NOTE merge(animal) differnt semantics
        // entityManager.flush() could be used
        entityManager.getTransaction().commit();
        return appointment;
    }

    @Override
    public List<Appointment> findAll() {
<<<<<<< HEAD
        TypedQuery<Appointment> q = entityManager.createQuery("SELECT a FROM Appointment a", Appointment.class);
        List<Appointment> appList = q.getResultList();
        return appList;
=======
        TypedQuery<Appointment> q = entityManager.createQuery("SELECT p FROM Appointment p", Appointment.class);
        List<Appointment> appointmentList = q.getResultList();
        return appointmentList;    
>>>>>>> f8b45a53c3b412b3b531c12447afc789b9c51ba3
    }

    @Override
    public boolean delete(Appointment appointment) {
        if(appointment==null) return false;
        entityManager.remove(appointment);
        return true;
    }

    @Override
    public boolean deleteById(Long id) {
        Appointment temp = findById( id);
        if(temp ==null) return false;
        entityManager.getTransaction().begin();
        entityManager.remove(temp);
        entityManager.getTransaction().commit();
        return true;        
    }

    @Override
    public void deleteAll() {
        entityManager.getTransaction().begin();
        entityManager.createQuery("DELETE FROM Appointment ").executeUpdate();
<<<<<<< HEAD
        entityManager.getTransaction().commit();    
    }
=======
        entityManager.getTransaction().commit();    }
>>>>>>> f8b45a53c3b412b3b531c12447afc789b9c51ba3

    @Override
    public List<Appointment> findByPersonA(Person personA) {
        TypedQuery<Appointment> q=entityManager.createQuery("SELECT a FORM Person a WHERE a.role = :role",Appointment.class);//EDIT
        return q.getResultList();    
    }

    @Override
    public List<Appointment> findByPersonB(Person personB) {
        TypedQuery<Appointment> q=entityManager.createQuery("SELECT a FORM Person a WHERE a.role = :role",Appointment.class);//EDIT
        return q.getResultList();       }

    @Override
    public List<Appointment> findByDate(Integer year, Integer month, Integer hour, Integer minutes) {
        TypedQuery<Appointment> q=entityManager.createQuery("SELECT a FORM Person a WHERE a.role = :role",Appointment.class);//EDIT
        return q.getResultList();       }

}
