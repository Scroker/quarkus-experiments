package org.acme.resource;

import java.util.Optional;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.acme.service.GreetingService;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("/hello")
public class GreetingResource {

    @Inject
    GreetingService service;

    @ConfigProperty(name = "greeting.message") 
    String message;
    
    @ConfigProperty(name = "greeting.suffix", defaultValue="!") 
    String suffix;
    
    @ConfigProperty(name = "greeting.name")
    Optional<String> name; 

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("{name}")
    public String greeting(@PathParam("name") String name) {
        return service.greeting(name);
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return message + " " + name.orElse("world") + suffix;
    }
}