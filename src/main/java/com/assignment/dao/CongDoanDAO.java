package com.assignment.dao;


import com.assignment.entity.congdoan.CongDoan;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class CongDoanDAO extends BaseDAO<CongDoan> {

    public CongDoanDAO() {
        super(CongDoan.class);
    }

    public List<CongDoan> findAll() {
        return em.createQuery("SELECT c FROM CongDoan c ORDER BY id", CongDoan.class)
                .getResultList();
    }


}
