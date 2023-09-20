package com.assignment.rest;


import com.assignment.service.ChiNoiTruService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/chi-noi-tru")
public class ChiNoiTruRest {

    @Inject
    private ChiNoiTruService chiNoiTruService;

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response findAll() {
        return Response.ok(chiNoiTruService.findAll()).build();
    }

    @GET
    @Path("/congdoan/{congdoanId}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response findByCongdoanAndMonth(@PathParam("congdoanId") int congdoanId, @QueryParam("month") int month, @QueryParam("year") int year) {
        return Response.ok(chiNoiTruService.findByCongdoanAndMonth(congdoanId, month, year)).build();
    }

    @GET
    @Path("/all")
    @Produces({MediaType.APPLICATION_JSON})
    public Response findByMonthForAllCongDoan(@QueryParam("month") int month, @QueryParam("year") int year) {
        return Response.ok(chiNoiTruService.findByMonthForAllCongDoan(month, year)).build();
    }

    @GET
    @Path("/month")
    @Produces({MediaType.APPLICATION_JSON})
    public Response findByCongdoanAndMonth(@QueryParam("month") int month, @QueryParam("year") int year) {
        return Response.ok(chiNoiTruService.findByMonth(month, year)).build();
    }
}