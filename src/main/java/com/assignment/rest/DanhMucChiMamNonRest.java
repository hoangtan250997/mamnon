package com.assignment.rest;


import com.assignment.service.DanhMucChiMamNonService;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/danh-muc-chi-mam-non")
public class DanhMucChiMamNonRest {

    @Inject
    private DanhMucChiMamNonService danhMucChiMamNonService;

    @GET
    @Produces({MediaType.APPLICATION_JSON})
     public Response findAll() {
        return Response.ok(danhMucChiMamNonService.findAll()).build();
    }
}