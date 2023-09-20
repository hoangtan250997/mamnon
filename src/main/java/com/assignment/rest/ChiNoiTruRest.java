package com.assignment.rest;


import com.assignment.service.ChiNoiTruService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/chinoitru")
public class ChiNoiTruRest {

    @Inject
    private ChiNoiTruService chiNoiTruService;

    @GET
    @Produces({MediaType.APPLICATION_JSON})
     public Response findAll() {
        return Response.ok(chiNoiTruService.findAll()).build();
    }
}