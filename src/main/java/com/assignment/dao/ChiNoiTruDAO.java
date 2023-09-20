package com.assignment.dao;


import com.assignment.entity.noitru.ChiNoiTru;
import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class ChiNoiTruDAO extends BaseDAO<ChiNoiTru> {

    public ChiNoiTruDAO() {
        super(ChiNoiTru.class);
    }

    public List<ChiNoiTru> findAll() {
        return em.createQuery("SELECT c FROM ChiNoiTru c", ChiNoiTru.class)
                .getResultList();
    }

    public List<ChiNoiTru> findByCongdoanAndMonth(int condoanId) {
        return em.createQuery("SELECT c FROM ChiNoiTru c WHERE congdoan.id = :condoanId", ChiNoiTru.class).setParameter("condoanId",condoanId)
                .getResultList();
    }

    public List<ChiNoiTru> findByMonth(int month,int year) {
        return em.createQuery("SELECT c FROM ChiNoiTru c WHERE month = :month AND year=:year", ChiNoiTru.class).setParameter("month",month).setParameter("year",year)
                .getResultList();
    }

}