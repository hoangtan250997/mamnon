package com.assignment.rest;


import com.assignment.mapper.CongDoanMapper;
import com.assignment.service.CongDoanService;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/cong-doan")
public class CongDoanRest {

    @Inject
    private CongDoanService congDoanService;
    @Inject
    CongDoanMapper congDoanMapper;
    @GET
    @Produces({MediaType.APPLICATION_JSON})
     public Response findAll() {
        return Response.ok(congDoanMapper.toDTOList(congDoanService.findAll())).build();
    }
}