package com.assignment.service;


import com.assignment.dao.DanhMucChiMamNonDAO;
import com.assignment.entity.thuchimamnon.DanhMucChiMamNon;
import com.assignment.mapper.DanhMucChiMamNonMapper;
import com.assignment.model.DanhMucChiMamNonResultDTO;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;


@RequestScoped
public class DanhMucChiMamNonService {

    @Inject
     DanhMucChiMamNonDAO danhMucChiMamNonDAO;

    @Inject
     DanhMucChiMamNonMapper danhMucChiMamNonMapper;

    public List<DanhMucChiMamNonResultDTO> findAll() {
        List<DanhMucChiMamNon> danhMucChiMamNonList = danhMucChiMamNonDAO.findAll();
        return danhMucChiMamNonMapper.toDTOList(danhMucChiMamNonList);
    }
}

