package org.solent.com504.project.model.service;

public interface ServiceFacade {
    
    public String getHeartbeat();
    
    boolean personOnSite(String name, String site);
    
    boolean personLeavingSite(String name, String site);
    
}
