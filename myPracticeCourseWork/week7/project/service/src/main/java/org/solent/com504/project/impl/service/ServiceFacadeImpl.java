package org.solent.com504.project.impl.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.solent.com504.project.model.dao.AppointmentDAO;
import org.solent.com504.project.model.dao.PersonDAO;
import org.solent.com504.project.model.dto.Appointment;
import org.solent.com504.project.model.dto.Person;
import org.solent.com504.project.model.dto.Role;
import org.solent.com504.project.model.service.ServiceFacade;

public class ServiceFacadeImpl implements ServiceFacade {

    final static Logger LOG = LogManager.getLogger(ServiceFacadeImpl.class);

    private PersonDAO personDao = null;

    private AppointmentDAO appointmentDao = null;

    // used to concurently count heartbeat requests
    private static AtomicInteger heartbeatRequests = new AtomicInteger();

    // setters for DAOs
    public void setPersonDao(PersonDAO personDao) {
        this.personDao = personDao;
    }

    public void setAppointmentDao(AppointmentDAO appointmentDao) {
        this.appointmentDao = appointmentDao;
    }

    // Service facade methods
    @Override
    public String getHeartbeat() {
        LOG.debug("get heartbeat called");
        return "heartbeat number " + heartbeatRequests.getAndIncrement() + " " + new Date().toString();
    }

    @Override
    public boolean personOnSite(String name, String site) {
        LOG.debug("personOnSite called site=" + site + "name=" + name);
        if (name == null || site == null) {
            return false;
        }
        Long nameid=null,siteid=null;
        try{
            nameid=Long.valueOf(name);
            siteid=Long.valueOf(site);
        }
        catch(NumberFormatException n){
            LOG.debug("Error converting site and name id to Long.");
        }
        
        Appointment tempapp=appointmentDao.findById(siteid);
        Person tempperson=personDao.findById(nameid);
        appointmentDao.deleteById(siteid);

        tempapp.setPersonB(tempperson);
        appointmentDao.save(tempapp);
        return true;
    }

    @Override
    public boolean personLeavingSite(String name, String site) {
        LOG.debug("personOnSite called site=" + site + "name=" + name);
        Long nameid=null,siteid=null;

        LOG.debug("personLeavingSite called");
        if (name == null || site == null) {
            return false;
        }
         try{
            nameid=Long.valueOf(name);
            siteid=Long.valueOf(site);
        }
        catch(NumberFormatException n){
            LOG.debug("Error converting site and name id to Long.");
        }
        Appointment tempapp=appointmentDao.findById(siteid);
        Person tempperson=personDao.findById(nameid);
        if(tempperson==null)return false;
        appointmentDao.deleteById(siteid);
        tempapp.setPersonB(null);
        
        appointmentDao.save(tempapp);

        return true;
    }

    @Override
    public Person findPersonById(Long id){
        return personDao.findById(id);
    }
    @Override
    public Person savePerson(Person person){
        return personDao.save(person);
    }
    @Override
    public List<Person> findAllPerson(){
        return personDao.findAll();
    }
    @Override
    
    public boolean deletePersonById(long id){
        return personDao.deleteById(id);
    }
   @Override

    public boolean deletePerson(Person person){
        return personDao.delete(person);
    }
    @Override
    public void deleteAllPerson(){
        personDao.deleteAll();
    }
    @Override
    public List<Person> findPersonByRole(Role role){
        return personDao.findByRole(role);
    }
    @Override
    public List<Person> findPersonByName(String firstName, String secondName){
        return personDao.findByName(firstName, secondName);
    }
    @Override
    public Appointment findAppById(Long id){
        return appointmentDao.findById(id);
    } 
    @Override
    public Appointment saveApp(Appointment app){
        return appointmentDao.save(app);
    }
    @Override
    public List<Appointment> findAllApps(){
        return appointmentDao.findAll();
    }
    @Override
    public boolean deleteApp(Appointment appointment){
        return appointmentDao.delete(appointment);
    }
    @Override
    public boolean deleteAppById(Long id){
        return appointmentDao.deleteById(id);
    }
    @Override
    public void deleteAllApps(){
        appointmentDao.deleteAll();
    }


}


