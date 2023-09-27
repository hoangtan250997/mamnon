package com.assignment.service;


import com.assignment.dao.DanhMucChiMamNonDAO;
import com.assignment.entity.thuchimamnon.DanhMucChiMamNon;
import com.assignment.mapper.DanhMucChiMamNonMapper;
import com.assignment.model.DanhMucChiMamNonDTO;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import java.util.List;

@RequestScoped

public class DanhMucChiMamNonService {

    @Inject
     DanhMucChiMamNonDAO danhMucChiMamNonDAO;

    @Inject
     DanhMucChiMamNonMapper danhMucChiMamNonMapper;

    public List<DanhMucChiMamNonDTO> findAll() {
        List<DanhMucChiMamNon> danhMucChiMamNonList = danhMucChiMamNonDAO.findAll();
        return danhMucChiMamNonMapper.toDTOList(danhMucChiMamNonList);
    }
}

