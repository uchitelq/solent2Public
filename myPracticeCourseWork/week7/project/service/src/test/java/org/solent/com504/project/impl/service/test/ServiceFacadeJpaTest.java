/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.solent.com504.project.impl.service.test;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.solent.com504.project.impl.service.ServiceObjectFactoryJpaImpl;
import org.solent.com504.project.model.dto.Appointment;
import org.solent.com504.project.model.dto.Person;
import org.solent.com504.project.model.dto.Role;
import org.solent.com504.project.model.service.ServiceFacade;
import org.solent.com504.project.model.service.ServiceObjectFactory;


/**
 *
 * @author gallenc
 */
public class ServiceFacadeJpaTest {
    
    ServiceObjectFactory serviceObjectFactory = null;
    ServiceFacade serviceFacade = null;


    @Before
    public void loadFactory() {

        serviceObjectFactory = new ServiceObjectFactoryJpaImpl();
        
        serviceFacade = serviceObjectFactory.getServiceFacade();

    }

    @Test
    public void testFactory() {
        System.out.println("start ServiceFacadeTest testFactory");
        assertNotNull(serviceFacade);

        System.out.println("end ServiceFacadeTest testFactory");
    }

    @Test
    public void testGetHeartbeat() {
        System.out.println("start ServiceFacadeTest testGetHeartbeat()");
        assertNotNull(serviceFacade);
        
        String heartbeat = serviceFacade.getHeartbeat();
        System.out.println("recieved heartbeat: "+heartbeat);
        assertNotNull(heartbeat);
        
        System.out.println("end FarmFacadeTest testGetHeartbeat()");
    }

    @Test
    public void testPersonOnSite(){
        System.out.println("start ServiceFacadeTest testPersonOnSite()");
        assertNotNull(serviceFacade);
        Appointment temp=new Appointment();
        temp.setDescripton("descr");
        temp.setDurationMinutes(20);
        temp.setHr(15);
        temp.setMth(07);
        temp.setYr(20);
        Person tempPerson=new Person();
        tempPerson.setAddress("address");
        tempPerson.setFirstName("fname");
        tempPerson.setSecondName("sname");
        tempPerson.setRole(Role.PATIENT);
        Person tperson=serviceFacade.savePerson(tempPerson);
        Long idapp=temp.getId();
        Long personid=tperson.getId();
        assertNotNull(serviceFacade.personOnSite(personid.toString(),idapp.toString()));
    }
    @Test
    public void testPersonLeavingSite(){
        assertNotNull(serviceFacade);
        Appointment temp=new Appointment();
        temp.setDescripton("descr");
        temp.setDurationMinutes(20);
        temp.setHr(15);
        temp.setMth(07);
        temp.setYr(20);
        Person tempPerson=new Person();
        tempPerson.setAddress("address");
        tempPerson.setFirstName("fname");
        tempPerson.setSecondName("sname");
        tempPerson.setRole(Role.PATIENT);
        Person tperson=serviceFacade.savePerson(tempPerson);
        temp.setPersonB(tperson);
        Long idapp=temp.getId();
        Long personid=tperson.getId();
        assertNotNull(serviceFacade.personLeavingSite(personid.toString(),idapp.toString()));
    }
}

