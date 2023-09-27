package com.assignment.dao;


import com.assignment.entity.noitru.ThuNoiTru;
import com.assignment.entity.thuchimamnon.DanhMucChiMamNon;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;

import java.util.List;

@ApplicationScoped
public class DanhMucChiMamNonDAO extends BaseDAO<DanhMucChiMamNon> {

    public DanhMucChiMamNonDAO() {
        super(DanhMucChiMamNon.class);
    }
    public List<DanhMucChiMamNon> findAll(int month, int year) {
        return em.createQuery("SELECT t FROM DanhMucChiMamNon t", DanhMucChiMamNon.class)
                .getResultList();
    }

}
