package com.assignment.rest;


import com.assignment.service.ThuNoiTruService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
    public Response findByMonthForAllCongDoan(@QueryParam("month") int month, @QueryParam("year") int year) {
        return Response.ok(thuNoiTruService.findByMonthForAllCongDoan(month, year)).build();
    }
    @GET
    @Path("/month")
    @Produces({MediaType.APPLICATION_JSON})
    public Response findByMonth(@QueryParam("month") int month,@QueryParam("year") int year) {
        return Response.ok(thuNoiTruService.findByMonth(month,year)).build();
    }
}