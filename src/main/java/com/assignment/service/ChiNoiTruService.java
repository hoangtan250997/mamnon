package com.assignment.service;


import com.assignment.dao.ChiNoiTruDAO;
import com.assignment.dao.DanhMucChiMamNonDAO;
import com.assignment.entity.noitru.ChiNoiTru;
import com.assignment.entity.thuchimamnon.DanhMucChiMamNon;
//import com.assignment.mapper.ChiNoiTruMapper;
import com.assignment.mapper.DanhMucChiMamNonMapper;
//import com.assignment.model.ChiNoiTruDTO;
import com.assignment.model.DanhMucChiMamNonDTO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;


@ApplicationScoped
public class ChiNoiTruService {

    @Inject
    ChiNoiTruDAO chiNoiTruDAO;

//    @Inject
//    ChiNoiTruMapper chiNoiTruMapper;

    public List<ChiNoiTru> findAll() {
        List<ChiNoiTru> chiNoiTruList = chiNoiTruDAO.findAll();
        return chiNoiTruList;
    }
}

