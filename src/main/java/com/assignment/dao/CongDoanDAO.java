package com.assignment.dao;


import com.assignment.entity.congdoan.CongDoan;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;

@ApplicationScoped
public class CongDoanDAO extends BaseDAO<CongDoan> {

    public CongDoanDAO() {
        super(CongDoan.class);
    }



}
