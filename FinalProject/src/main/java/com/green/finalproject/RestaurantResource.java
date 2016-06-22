/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.green.finalproject;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

@Path("restaurant")
public class RestaurantResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of RestaurantResource
     */
    public RestaurantResource() {
    }

    /**
     * Retrieves representation of an instance of com.green.finalproject.RestaurantResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/test")
    @Produces(MediaType.APPLICATION_XML)
    public String getXml() {
        //TODO return proper representation object
        return "Teste 1";
    }

    /**
     * PUT method for updating or creating an instance of RestaurantResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/xml")
    public void putXml(String content) {
    }
}
