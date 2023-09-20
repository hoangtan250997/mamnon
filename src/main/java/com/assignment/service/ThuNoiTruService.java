package com.assignment.service;


import com.assignment.dao.ChiNoiTruDAO;
import com.assignment.dao.ThuNoiTruDAO;
import com.assignment.entity.noitru.ChiNoiTru;
import com.assignment.entity.noitru.DanhMucChiNoiTru;
import com.assignment.entity.noitru.DanhMucThuNoiTru;
import com.assignment.entity.noitru.ThuNoiTru;
import com.assignment.mapper.ChiNoiTruMapper;
import com.assignment.mapper.ThuNoiTruMapper;
import com.assignment.model.ChiNoiTruDTO;
import com.assignment.model.ChiNoiTruResultDTO;
import com.assignment.model.ThuNoiTruDTO;
import com.assignment.model.ThuNoiTruResultDTO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@ApplicationScoped
public class ThuNoiTruService {

    @Inject
    ThuNoiTruDAO thuNoiTruDAO;

    @Inject
    ThuNoiTruMapper thuNoiTruMapper;

    public List<ThuNoiTruDTO> findAll() {
        List<ThuNoiTru> thuNoiTruList = thuNoiTruDAO.findAll();
        return thuNoiTruMapper.toDTOList(thuNoiTruList);
    }


    public List<ThuNoiTruDTO> findByMonth(int month,int year) {
        List<ThuNoiTru> thuNoiTruList = thuNoiTruDAO.findByMonth(month,year);
        return thuNoiTruMapper.toDTOList(thuNoiTruList);
    }

    public List<ThuNoiTruResultDTO> findByMonthForAllCongDoan(int month, int year) {
        List<ThuNoiTruResultDTO> thuNoiTruResultDTOList = new ArrayList<>();
        List<ThuNoiTru> thuNoiTruList = thuNoiTruDAO.findByMonth(month, year);
        Map<DanhMucThuNoiTru, List<ThuNoiTru>> sumByCategory = thuNoiTruList.stream()
                .collect(Collectors.groupingBy(
                        ThuNoiTru::getDanhMucThuNoiTru
                ));
        for (Map.Entry<DanhMucThuNoiTru, List<ThuNoiTru>> danhMucThuNoiTru : sumByCategory.entrySet()) {
            ThuNoiTruResultDTO thuNoiTruResultDTO = ThuNoiTruResultDTO.builder()
                    .danhMucThuNoiTruName(danhMucThuNoiTru.getKey().getName())
                    .amount(danhMucThuNoiTru.getValue().stream().mapToLong(value -> value.getAmount()).sum())
//                    .usdAmount(BigDecimal.valueOf(danhMucThuNoiTru.getValue().stream().mapToDouble(value -> value.getUsdAmount().doubleValue()).sum()))
                    .build();
            thuNoiTruResultDTOList.add(thuNoiTruResultDTO);
        }
        return thuNoiTruResultDTOList;
    }
}

