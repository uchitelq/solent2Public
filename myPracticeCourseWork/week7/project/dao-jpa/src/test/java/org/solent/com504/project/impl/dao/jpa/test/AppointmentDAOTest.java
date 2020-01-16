/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.solent.com504.project.impl.dao.jpa.test;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static org.apache.logging.log4j.spi.ThreadContextMapFactory.init;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.solent.com504.project.impl.dao.jpa.DAOFactoryJPAImpl;
import org.solent.com504.project.model.dao.AppointmentDAO;
import org.solent.com504.project.model.dao.PersonDAO;
import org.solent.com504.project.model.dto.Appointment;
import org.solent.com504.project.model.dto.Person;
import org.solent.com504.project.model.dto.Role;


/**
 *
 * @author cgallen
 */
public class AppointmentDAOTest {

    final static Logger LOG = LogManager.getLogger(AppointmentDAOTest.class);

    private AppointmentDAO appointmentDao = null;
    private PersonDAO personDao=null;//needed for search by person
    private DAOFactoryJPAImpl daoFactory = new DAOFactoryJPAImpl();

    @Before
    public void before() {
        appointmentDao = daoFactory.getAppointmentDAO();
        personDao=daoFactory.getPersonDAO();
        assertNotNull(appointmentDao);
    }

    @Test
    public void createAppointmentDAOTest() {
        LOG.debug("start of createAppointmentDAOTest(");
        // this test simply runs the before method
        LOG.debug("end of createAppointmentDAOTest(");
    }
    
    
    @Test
    public void findByIdTest() {
        LOG.debug("start of findByIdTest()");
        Long id=null;
        Appointment temp=new Appointment();
        Appointment temp2=new Appointment();
        temp.setDescripton("descr");
        temp.setDurationMinutes(20);
        temp.setHr(15);
        temp.setMth(07);
        temp.setYr(20);
        temp2=appointmentDao.save(temp);
        id=temp2.getId();
        Appointment temp3=new Appointment();
        temp3=appointmentDao.findById(id);
        assertEquals(temp3.getId(),id);
        LOG.debug("end of findByIdTest()");
    }

    @Test
    public void saveTest() {
        LOG.debug("start of saveTest()");
        Appointment temp=new Appointment();
        temp.setDescripton("descr");
        temp.setDurationMinutes(20);
        temp.setHr(15);
        temp.setMth(07);
        temp.setYr(20);
        assertNotNull(appointmentDao.save(temp));
        LOG.debug("end of saveTest()");
    }

    @Test
    public void findAllTest() {
        LOG.debug("start of findAllTest()");

        init();
       Appointment temp=new Appointment();
        temp.setDescripton("descr");
        temp.setDurationMinutes(20);
        temp.setHr(15);
        temp.setMth(07);
        temp.setYr(20);
        appointmentDao.save(temp);
        List<Appointment> appList = appointmentDao.findAll();
        String msg = "";
        for (Appointment app : appList) {
            msg = msg +"\n   " +  app.toString();
        }
        LOG.debug("findAllTest() retrieved:" + msg);
        assertFalse(appList.isEmpty());
        LOG.debug("end of findAllTest()");
    }

    @Test
    public void deleteByIdTest() {
        appointmentDao.deleteAll();
        LOG.debug("start of deleteByIdTest()");
        Long id=null;
        Appointment temp=new Appointment();
        temp.setDescripton("descr");
        temp.setDurationMinutes(20);
        temp.setHr(15);
        temp.setMth(07);
        temp.setYr(20);
        Appointment temp2=appointmentDao.save(temp);
        
        id=temp2.getId();
        assertTrue(appointmentDao.deleteById(id));
        LOG.debug("end of deleteByIdTest()");
    }

    @Test
    public void deleteTest() {
        appointmentDao.deleteAll();
        LOG.debug("start of deleteTest()");
        Long id=null;
        Appointment temp=new Appointment();
        temp.setDescripton("descr");
        temp.setDurationMinutes(20);
        temp.setHr(15);
        temp.setMth(07);
        temp.setYr(20);
        Appointment temp2=appointmentDao.save(temp);
        id=temp2.getId();
        assertTrue(appointmentDao.delete(temp));
        LOG.debug("end ofdeleteTest()");
    }

    @Test
    public void deleteAllTest() {
        LOG.debug("start of deleteAllTest())");
        LOG.debug("start of deleteTest()");
        Appointment temp=new Appointment();
        temp.setDescripton("descr");
        temp.setDurationMinutes(20);
        temp.setHr(15);
        temp.setMth(07);
        temp.setYr(20);
        appointmentDao.save(temp);
        appointmentDao.deleteAll();
        List<Appointment> appList = appointmentDao.findAll();
        assertTrue(appList.isEmpty());
        LOG.debug("end of deleteAllTest()");
    }


}

    
    
    
    
    

