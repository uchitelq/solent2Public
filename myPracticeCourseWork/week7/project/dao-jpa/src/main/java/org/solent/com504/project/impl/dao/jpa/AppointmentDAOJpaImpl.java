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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Appointment> findAll() {
        TypedQuery<Appointment> q = entityManager.createQuery("SELECT p FROM Appointment p", Appointment.class);
        List<Appointment> appointmentList = q.getResultList();
        return appointmentList;    
    }

    @Override
    public Appointment delete(Appointment appointment) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteAll() {
        entityManager.getTransaction().begin();
        entityManager.createQuery("DELETE FROM Appointment ").executeUpdate();
        entityManager.getTransaction().commit();    }

    @Override
    public List<Appointment> findByPersonA(Person personA) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Appointment> findByPersonB(Person personB) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Appointment> findByDate(Integer year, Integer month, Integer hour, Integer minutes) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
