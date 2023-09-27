package com.assignment.dao;


import com.assignment.entity.noitru.DanhMucThuNoiTru;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;

@ApplicationScoped
public class DanhMucThuNoiTruDAO extends BaseDAO<DanhMucThuNoiTru> {

    public DanhMucThuNoiTruDAO() {
        super(DanhMucThuNoiTru.class);
    }

}
