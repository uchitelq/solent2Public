package org.solent.com504.project.model.service;

import java.util.List;
import org.solent.com504.project.model.dto.Appointment;
import org.solent.com504.project.model.dto.Person;
import org.solent.com504.project.model.dto.Role;

public interface ServiceFacade {
    
    public String getHeartbeat();
    
    public boolean personOnSite(String name, String site);
    
    public boolean personLeavingSite(String name, String site);
    
    
    public Person findPersonById(Long id);
    public Person savePerson(Person person);
    public List<Person> findAllPerson();
    public boolean deletePersonById(long id);
    public boolean deletePerson(Person person);
    public void deleteAllPerson();
    public List<Person> findPersonByRole(Role role);
    public List<Person> findPersonByName(String firstName, String secondName);
    public Appointment findAppById(Long id);
    public Appointment saveApp(Appointment app);
    public List<Appointment> findAllApps();
    public boolean deleteApp(Appointment appointment);

    public boolean deleteAppById(Long id);
    public void deleteAllApps();
    
}
