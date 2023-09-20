package com.assignment.dao;


import com.assignment.entity.noitru.DanhMucThuNoiTru;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DanhMucThuNoiTruDAO extends BaseDAO<DanhMucThuNoiTru> {

    public DanhMucThuNoiTruDAO() {
        super(DanhMucThuNoiTru.class);
    }

}
