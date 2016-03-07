package com.beauchef.rest;

import com.beauchef.service.CalculatorService;
import com.beauchef.service.CounterService;

import javax.inject.Inject;
import javax.naming.NamingException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jean- on 2016-03-06.
 */
@Path("/count")
public class CounterResource {

    @Inject
    CounterService counter;

    @GET
    @Path("/inc/{n}")
    @Produces({ "application/json" })
    public Response inc(@PathParam("n") int n) {
        try {
            return Response.status(200).entity(counter.inc(n)).build();
        } catch (NamingException nex) {
            return Response.serverError().build();
        }
    }

    @GET
    @Path("/dec/{n}")
    @Produces({ "application/json" })
    public Response dec(@PathParam("n") int n) {
        try {
            return Response.status(200).entity(counter.dec(n)).build();
        } catch (NamingException nex) {
            return Response.serverError().build();
        }
    }

}
