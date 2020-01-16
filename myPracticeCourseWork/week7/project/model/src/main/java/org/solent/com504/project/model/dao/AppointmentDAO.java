package org.solent.com504.project.model.dao;

import java.util.List;
import org.solent.com504.project.model.dto.Appointment;
import org.solent.com504.project.model.dto.Person;

public interface AppointmentDAO {

    public Appointment findById(Long id);

    public Appointment save(Appointment appointment);

    public List<Appointment> findAll();

    public boolean delete(Appointment appointment);

    public boolean deleteById(Long id);

    public void deleteAll();


}
