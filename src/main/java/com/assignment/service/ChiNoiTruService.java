package com.assignment.service;


import com.assignment.dao.ChiNoiTruDAO;
import com.assignment.entity.noitru.ChiNoiTru;
import com.assignment.entity.noitru.DanhMucChiNoiTru;
import com.assignment.mapper.ChiNoiTruMapper;
import com.assignment.mapper.ChiNoiTruResultMapper;
import com.assignment.model.ChiNoiTruDTO;
import com.assignment.model.ChiNoiTruResultDTO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


@ApplicationScoped
public class ChiNoiTruService {

    @Inject
    ChiNoiTruDAO chiNoiTruDAO;

    @Inject
    ChiNoiTruMapper chiNoiTruMapper;
    @Inject
    ChiNoiTruResultMapper chiNoiTruResultMapper;

    public List<ChiNoiTru> findAll() {
        List<ChiNoiTru> chiNoiTruList = chiNoiTruDAO.findAll();
        return chiNoiTruList;
    }

    public List<ChiNoiTruResultDTO> findByCongdoanAndMonth(int condoanId, int month, int year) {
//        List<ChiNoiTru> chiNoiTruList = chiNoiTruDAO.findByCongdoanAndMonth(condoanId).stream().filter(chiNoiTru -> chiNoiTru.getMonth() == month && chiNoiTru.getYear() == year ).collect(Collectors.toList());
        List<ChiNoiTru> chiNoiTruList = chiNoiTruDAO.findByMonth(month, year).stream().filter(chiNoiTru -> chiNoiTru.getCongdoan().getId() == condoanId).collect(Collectors.toList());
        return chiNoiTruResultMapper.toDTOList(chiNoiTruList);
    }

    public List<ChiNoiTruDTO> findByMonth(int month, int year) {
        List<ChiNoiTru> chiNoiTruList = chiNoiTruDAO.findByMonth(month, year);
        return chiNoiTruMapper.toDTOList(chiNoiTruList);
    }

    public List<ChiNoiTruResultDTO> findByMonthForAllCongDoan( int month, int year) {
        List<ChiNoiTruResultDTO> chiNoiTruResultDTOList = new ArrayList<>();
        List<ChiNoiTru> chiNoiTruList = chiNoiTruDAO.findByMonth(month, year);
        Map<DanhMucChiNoiTru, List<ChiNoiTru>> sumByCategory = chiNoiTruList.stream()
                .collect(Collectors.groupingBy(
                        ChiNoiTru::getDanhMucChiNoiTru
                ));
        for (Map.Entry<DanhMucChiNoiTru, List<ChiNoiTru>> danhMucChiNoiTru : sumByCategory.entrySet()) {
            ChiNoiTruResultDTO chiNoiTruResultDTO = ChiNoiTruResultDTO.builder()
                    .danhMucChiNoiTruName(danhMucChiNoiTru.getKey().getName())
                    .amount(danhMucChiNoiTru.getValue().stream().mapToLong(value -> value.getAmount()).sum())
                    .usdAmount(BigDecimal.valueOf(danhMucChiNoiTru.getValue().stream().mapToDouble(value -> value.getUsdAmount().doubleValue()).sum()))
                    .build();
            chiNoiTruResultDTOList.add(chiNoiTruResultDTO);
        }
        return chiNoiTruResultDTOList;
    }
}

