package com.beauchef.rest;

import com.beauchef.service.CalculatorService;

import javax.inject.Inject;
import javax.naming.NamingException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 * Created by jean- on 2016-03-06.
 */
@Path("/calc")
public class CalculatorResource {

    @Inject
    CalculatorService calculator;

    @GET
    @Path("/add/{n1}/{n2}")
    @Produces({ "application/json" })
    public Response add(@PathParam("n1") int n1, @PathParam("n2") int n2) {
        try {
            return Response.status(200).entity("" + n1 + " + " + n2 + " = " + calculator.add(n1, n2)).build();
        } catch (NamingException nex) {
            return Response.serverError().build();
        }
    }

    @GET
    @Path("/sub/{n1}/{n2}")
    @Produces({ "application/json" })
    public Response sub(@PathParam("n1") int n1, @PathParam("n2") int n2) {
        try {
            return Response.status(200).entity("" + n1 + " - " + n2 + " = " + calculator.subtract(n1, n2)).build();
        } catch (NamingException nex) {
            return Response.serverError().build();
        }
    }
}
