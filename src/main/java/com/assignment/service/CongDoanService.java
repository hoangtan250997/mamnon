package com.assignment.service;


import com.assignment.dao.CongDoanDAO;
import com.assignment.entity.congdoan.CongDoan;
import com.assignment.mapper.CongDoanMapper;
import com.assignment.model.CongDoanDTO;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import java.util.List;

@RequestScoped
public class CongDoanService {

    @Inject
    CongDoanDAO congDoanDAO;

    @Inject
    CongDoanMapper congDoanMapper;

    public List<CongDoan> findAll() {
        List<CongDoan> congDoanList = congDoanDAO.findAll();
        return (congDoanList);
    }
}

