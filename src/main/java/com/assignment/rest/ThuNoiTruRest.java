package com.assignment.rest;


import com.assignment.service.ThuNoiTruService;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/thu-noi-tru")
public class ThuNoiTruRest {

    @Inject
    private ThuNoiTruService thuNoiTruService;

    @GET
    @Produces({MediaType.APPLICATION_JSON})
     public Response findAll() {
        return Response.ok(thuNoiTruService.findAll()).build();
    }

    @GET
    @Path("/all")
    @Produces({MediaType.APPLICATION_JSON})
    public Response findByMonthForAllCongDoan(@QueryParam("month") int month,@QueryParam("year") int year) {
        return Response.ok(thuNoiTruService.findByMonthForAllCongDoan(month,year)).build();
    }
}