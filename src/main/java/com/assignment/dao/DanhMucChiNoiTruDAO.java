package com.assignment.dao;


import com.assignment.entity.noitru.DanhMucChiNoiTru;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;

@ApplicationScoped
public class DanhMucChiNoiTruDAO extends BaseDAO<DanhMucChiNoiTru> {

    public DanhMucChiNoiTruDAO() {
        super(DanhMucChiNoiTru.class);
    }

}
