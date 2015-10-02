/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import generator.DataGenerator;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;

/**
 * REST Web Service
 *
 * @author Nikolaj
 */
@Path("addresses")
public class DataService {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of DataService
     */
    public DataService() {
    }

    /**
     * Retrieves representation of an instance of service.DataService
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{count}/{properties}")
    @Produces("application/json")
    public String getJson(@PathParam("count") int count, @PathParam("properties") String properties) {
        return DataGenerator.getData(count, properties);
    }


}
