package com.assignment.rest;


import com.assignment.dao.DanhMucChiNoiTruDAO;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/danh-muc-chi-noi-tru")
public class DanhMucChiNoiTruRest {

    @Inject
    private DanhMucChiNoiTruDAO danhMucChiNoiTruDAO;

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response findAll() {
        return Response.ok(danhMucChiNoiTruDAO.findAll()).build();
    }


}