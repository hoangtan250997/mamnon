package com.assignment.dao;


import com.assignment.entity.thuchimamnon.DanhMucChiMamNon;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DanhMucChiMamNonDAO extends BaseDAO<DanhMucChiMamNon> {

    public DanhMucChiMamNonDAO() {
        super(DanhMucChiMamNon.class);
    }


}
