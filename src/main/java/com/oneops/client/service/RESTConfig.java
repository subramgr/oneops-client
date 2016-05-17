package com.oneops.client.service;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

/*
 * TODO: Delete!
 * Does not seem to be needed
 */
//@ApplicationPath("/rest")
public class RESTConfig extends Application{
    
    private static final Logger logger = Logger.getLogger(RESTConfig.class.getName());
   
    private final Set<Class<?>> classes;

    public RESTConfig() {
        logger.info("@@@@@ Inside RESTConfig...");
        HashSet<Class<?>> c = new HashSet<>();
        c.add(VariableService.class);
        c.add(EnvironmentService.class);
        c.add(DeploymentService.class);
        c.add(PlatformService.class);
        classes = Collections.unmodifiableSet(c);
        
    }

    @Override
    public Set<Class<?>> getClasses() {
        logger.info("@@@@@ Inside RESTConfig...getClasses()..");
        return classes;
    }
    
}