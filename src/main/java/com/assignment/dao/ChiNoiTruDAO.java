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

}
