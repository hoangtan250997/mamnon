package com.assignment.rest;


import com.assignment.service.ChiNoiTruService;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

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


}