package com.assignment.dao;


import com.assignment.entity.noitru.ChiNoiTru;
import com.assignment.entity.noitru.ThuNoiTru;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class ThuNoiTruDAO extends BaseDAO<ThuNoiTru> {

    public ThuNoiTruDAO() {
        super(ThuNoiTru.class);
    }

    public List<ThuNoiTru> findAll() {
        return em.createQuery("SELECT t FROM ThuNoiTru t", ThuNoiTru.class)
                .getResultList();
    }

    public List<ThuNoiTru> findByMonth(int month, int year) {
        return em.createQuery("SELECT t FROM ThuNoiTru t WHERE month = :month AND year=:year", ThuNoiTru.class).setParameter("month",month).setParameter("year",year)
                .getResultList();
    }

}
