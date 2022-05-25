package org.acme.resource;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ApplicationScoped
public class Resources {
    
    @Inject
    @PersistenceContext
    EntityManager em;

}
