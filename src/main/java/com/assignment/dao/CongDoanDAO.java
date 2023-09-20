package com.assignment.dao;


import com.assignment.entity.congdoan.CongDoan;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CongDoanDAO extends BaseDAO<CongDoan> {

    public CongDoanDAO() {
        super(CongDoan.class);
    }



}
