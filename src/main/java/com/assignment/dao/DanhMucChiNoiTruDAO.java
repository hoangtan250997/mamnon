package com.assignment.dao;


import com.assignment.entity.noitru.DanhMucChiNoiTru;
import com.assignment.entity.thuchimamnon.DanhMucChiMamNon;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class DanhMucChiNoiTruDAO extends BaseDAO<DanhMucChiNoiTru> {

    public DanhMucChiNoiTruDAO() {
        super(DanhMucChiNoiTru.class);
    }

}
