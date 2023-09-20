package com.assignment.service;


import com.assignment.dao.CongDoanDAO;
import com.assignment.dao.DanhMucChiMamNonDAO;
import com.assignment.entity.congdoan.CongDoan;
import com.assignment.entity.thuchimamnon.DanhMucChiMamNon;
import com.assignment.mapper.CongDoanMapper;
import com.assignment.mapper.DanhMucChiMamNonMapper;
import com.assignment.model.CongDoanDTO;
import com.assignment.model.DanhMucChiMamNonDTO;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;


@RequestScoped
public class CongDoanService {

    @Inject
    CongDoanDAO congDoanDAO;

    @Inject
    CongDoanMapper congDoanMapper;

    public List<CongDoanDTO> findAll() {
        List<CongDoan> congDoanList = congDoanDAO.findAll();
        return congDoanMapper.toDTOList(congDoanList);
    }
}

