package org.solent.com504.project.impl.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.solent.com504.project.model.dao.AppointmentDAO;
import org.solent.com504.project.model.dao.PersonDAO;
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
        return true;
    }

    @Override
    public boolean personLeavingSite(String name, String site) {
        LOG.debug("personOnSite called");
        return true;
    }

}
