package org.solent.com504.project.model.service;

public interface ServiceFacade {
    
    public String getHeartbeat();
    
    public boolean personOnSite(String name, String site);
    
    public boolean personLeavingSite(String name, String site);
    
}
