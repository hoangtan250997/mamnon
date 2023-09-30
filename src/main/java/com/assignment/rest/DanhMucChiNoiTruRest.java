package com.assignment.rest;


import com.assignment.dao.DanhMucChiNoiTruDAO;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/danh-muc-chi-noi-tru")
public class DanhMucChiNoiTruRest {

    @Inject
    private DanhMucChiNoiTruDAO danhMucChiNoiTruDAO;

    @GET
    @Path("/all")
    @Produces({MediaType.APPLICATION_JSON})
    public Response findAll() {
        return Response.ok(danhMucChiNoiTruDAO.findAll()).build();
    }


}