package com.assignment.dao;


import com.assignment.entity.noitru.DanhMucChiNoiTru;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DanhMucChiNoiTruDAO extends BaseDAO<DanhMucChiNoiTru> {

    public DanhMucChiNoiTruDAO() {
        super(DanhMucChiNoiTru.class);
    }

}
