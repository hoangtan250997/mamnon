package com.assignment.rest;


import com.assignment.service.CongDoanService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/cong-doan")
public class CongDoanRest {

    @Inject
    private CongDoanService congDoanService;

    @GET
    @Produces({MediaType.APPLICATION_JSON})
     public Response findAll() {
        return Response.ok(congDoanService.findAll()).build();
    }
}