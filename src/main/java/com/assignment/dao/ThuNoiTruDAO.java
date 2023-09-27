package com.assignment.dao;


import com.assignment.entity.noitru.ThuNoiTru;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;

import java.util.List;
@ApplicationScoped
public class ThuNoiTruDAO extends BaseDAO<ThuNoiTru> {

    public ThuNoiTruDAO() {
        super(ThuNoiTru.class);
    }

    public List<ThuNoiTru> findByMonth(int month, int year) {
        return em.createQuery("SELECT t FROM ThuNoiTru t WHERE month = :month AND year=:year", ThuNoiTru.class).setParameter("month", month).setParameter("year", year)
                .getResultList();
    }

}
