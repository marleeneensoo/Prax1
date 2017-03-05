package ttu.idu0080.config;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.core.Application;

import ttu.idu0080.controllers.BookController;

public class JsonConfig extends Application{
	//Add Service APIs
    @Override
    public Set<Class<?>> getClasses(){
        Set<Class<?>> resources = new HashSet<Class<?>>();
        resources.add(BookController.class);
        resources.add(org.glassfish.jersey.moxy.json.MoxyJsonFeature.class);
        resources.add(JsonMoxyConfigurationContextResolver.class);
        return resources;
    }
}
