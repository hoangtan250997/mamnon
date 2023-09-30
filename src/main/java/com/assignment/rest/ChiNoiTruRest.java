package com.assignment.rest;


import com.assignment.dao.ChiNoiTruDAO;
import com.assignment.service.ChiNoiTruService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/chi-noi-tru")
@ApplicationScoped
public class ChiNoiTruRest {

    @Inject
    private ChiNoiTruService chiNoiTruService;

    @Inject
    private ChiNoiTruDAO chiNoiTruDAO;

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