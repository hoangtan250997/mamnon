package com.assignment.dao;


import com.assignment.entity.thuchimamnon.DanhMucChiMamNon;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class DanhMucChiMamNonDAO extends BaseDAO<DanhMucChiMamNon> {

    public DanhMucChiMamNonDAO() {
        super(DanhMucChiMamNon.class);
    }

    public List<DanhMucChiMamNon> findAll() {
        return em.createQuery("SELECT d FROM DanhMucChiMamNon d", DanhMucChiMamNon.class)
                .getResultList();
    }


}
