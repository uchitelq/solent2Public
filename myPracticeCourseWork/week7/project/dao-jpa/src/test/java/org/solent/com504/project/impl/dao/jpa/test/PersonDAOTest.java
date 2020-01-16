/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.solent.com504.project.impl.dao.jpa.test;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.solent.com504.project.impl.dao.jpa.DAOFactoryJPAImpl;
import org.solent.com504.project.model.dao.PersonDAO;
import org.solent.com504.project.model.dto.Person;
import org.solent.com504.project.model.dto.Role;

/**
 *
 * @author cgallen
 */
public class PersonDAOTest {

    final static Logger LOG = LogManager.getLogger(PersonDAOTest.class);

    private PersonDAO personDao = null;

    private DAOFactoryJPAImpl daoFactory = new DAOFactoryJPAImpl();

    @Before
    public void before() {
        personDao = daoFactory.getPersonDAO();
        assertNotNull(personDao);
    }

    // initialises database for each test
    private void init() {
        // delete all in database
        personDao.deleteAll();
        for (int i = 1; i < 6; i++) {
            Person p = new Person();
            p.setAddress("address_" + i);
            p.setFirstName("firstName_" + i);
            p.setSecondName("secondName_" + i);
            p.setRole(Role.PATIENT);
            personDao.save(p);
        }
    }

    @Test
    public void createPersonDAOTest() {
        LOG.debug("start of createPersonDAOTest");
        // this test simply runs the before method
        LOG.debug("end of createPersonDAOTest");
    }

   


    @Test
    public void findAllTest() {
        LOG.debug("start of findAllTest()");

        init();
        List<Person> personList = personDao.findAll();
        assertNotNull(personList);
        
        // init should insert 5 people
        //assertEquals(5, personList.size());
        Person temp=new Person();
        temp.setAddress("address");
        temp.setFirstName("fname");
        temp.setSecondName("sname");
        temp.setRole(Role.PATIENT);
        // print out result
        String msg = "";
        for (Person person : personList) {
            msg = msg +"\n   " +  person.toString();
        }
        LOG.debug("findAllTest() retrieved:" + msg);

        assertFalse(personList.isEmpty());
        LOG.debug("end of findAllTest()");
    }

        @Test
        public void saveTest() {
        personDao.deleteAll();
        LOG.debug("start of saveTest()");
        Person temp=new Person();
        temp.setAddress("address");
        temp.setFirstName("fname");
        temp.setSecondName("sname");
        temp.setRole(Role.PATIENT);
        assertNotNull(personDao.save(temp));
        LOG.debug("end of saveTest()");
    }
     @Test
    public void findByIdTest() {
        personDao.deleteAll();

        LOG.debug("start of findByIdTest()");
        Long id=null;
        Person temp=new Person();
        Person temp2=new Person();
        temp.setAddress("address");
        temp.setFirstName("fname");
        temp.setSecondName("sname");
        temp.setRole(Role.PATIENT);
        temp2=personDao.save(temp);
        id=temp2.getId();
        Person temp3=new Person();
        temp3=personDao.findById(id);
        assertEquals(temp3.getId(),id);
        LOG.debug("end of findByIdTest()");
    }

    @Test
    public void deleteByIdTest() {
        personDao.deleteAll();

        LOG.debug("start of deleteByIdTest()");
        Long id=null;
        Person temp=new Person();
        temp.setAddress("address");
        temp.setFirstName("fname");
        temp.setSecondName("sname");
        temp.setRole(Role.PATIENT);
        Person temp2=personDao.save(temp);
        
        id=temp2.getId();
        assertTrue(personDao.deleteById(id));
        LOG.debug("end of deleteByIdTest()");
    }

    @Test
    public void deleteTest() {
        personDao.deleteAll();
        LOG.debug("start of deleteTest()");
        Long id=null;
        Person temp=new Person();
        temp.setAddress("address");
        temp.setFirstName("fname");
        temp.setSecondName("sname");
        temp.setRole(Role.PATIENT);
        Person temp2=personDao.save(temp);
        id=temp2.getId();
        assertTrue(personDao.delete(temp));
        LOG.debug("end ofdeleteTest()");
    }

    @Test
    public void deleteAllTest() {
        
        LOG.debug("start of deleteAllTest())");
        LOG.debug("start of deleteTest()");
        Person temp=new Person();
        temp.setAddress("address");
        temp.setFirstName("fname");
        temp.setSecondName("sname");
        temp.setRole(Role.PATIENT);
        personDao.save(temp);
        personDao.deleteAll();
        List<Person> personList = personDao.findAll();
        assertTrue(personList.isEmpty());
        LOG.debug("end of deleteAllTest()");
    }

    @Test
    public void findByRoleTest() {
        personDao.deleteAll();
        LOG.debug("start of findByIdTest()");
        Person temp=new Person();
        temp.setAddress("address");
        temp.setFirstName("fname");
        temp.setSecondName("sname");
        temp.setRole(Role.PATIENT);
        personDao.save(temp);
        personDao.deleteAll();
        List<Person> personList = personDao.findByRole(Role.PATIENT);
        for (Person person : personList) {
            assertTrue(person.getRole().toString().equals("PATIENT"));
        }
        LOG.debug("end of deleteAllTest()");      
        LOG.debug("end of findByIdTest()");
    }

    @Test
    public void findByNameTest() {
        personDao.deleteAll();
        LOG.debug("start of findByNameTest()");
 Person temp=new Person();
        temp.setAddress("address");
        temp.setFirstName("fname");
        temp.setSecondName("sname");
        temp.setRole(Role.PATIENT);
        personDao.save(temp);
        personDao.deleteAll();
        List<Person> personList = personDao.findByName("fname","sname");
        for (Person person : personList) {
            assertTrue(person.getFirstName().equals("fname")&&person.getSecondName().equals("sname"));
        }
        LOG.debug("end of deleteAllTest()");      
        LOG.debug("end of findByIdTest()");
        LOG.debug("end of findByNameTest())");

    }
}
