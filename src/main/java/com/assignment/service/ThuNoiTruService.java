package com.assignment.service;


import com.assignment.dao.DanhMucThuNoiTruDAO;
import com.assignment.dao.ThuNoiTruDAO;
import com.assignment.entity.noitru.DanhMucThuNoiTru;
import com.assignment.entity.noitru.ThuNoiTru;
import com.assignment.mapper.ThuNoiTruMapper;
import com.assignment.model.DanhMucThuNoiTruResultDTO;
import com.assignment.model.ThuNoiTruDTO;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequestScoped
public class ThuNoiTruService {

    @Inject
    ThuNoiTruDAO thuNoiTruDAO;

    @Inject
    ThuNoiTruMapper thuNoiTruMapper;

    @Inject
    DanhMucThuNoiTruDAO danhMucThuNoiTruDAO;

    public List<ThuNoiTruDTO> findAll() {
        List<ThuNoiTru> thuNoiTruList = thuNoiTruDAO.findAll();
        return thuNoiTruMapper.toDTOList(thuNoiTruList);
    }

    public List<DanhMucThuNoiTruResultDTO> findByMonthForAllCongDoan(int month, int year) {
        List<ThuNoiTru> thuNoiTruList = thuNoiTruDAO.findByMonth(month, year)
                .stream()
                .collect(Collectors.toList());
        Map<String, DanhMucThuNoiTruResultDTO> danhMucThuNoiTruMap = createDanhMucThuNoiTru();

        for (Map.Entry<String, DanhMucThuNoiTruResultDTO> danhMucThuNoiTru : danhMucThuNoiTruMap.entrySet()) {
            String key = danhMucThuNoiTru.getKey();
            if (checkExisting(key, thuNoiTruList)) {
                DanhMucThuNoiTruResultDTO danhMucResultDTO = danhMucThuNoiTru.getValue();

                List<ThuNoiTru> thuNoiTruListMatchKey = thuNoiTruList.stream()
                        .filter(thuNoiTru -> thuNoiTru.getDanhMucThuNoiTru().getName().equals(key)).collect(Collectors.toList());

                danhMucResultDTO.setAmount(thuNoiTruListMatchKey.stream().allMatch(thuNoiTru -> thuNoiTru.getAmount() == null) ? null : thuNoiTruListMatchKey.stream().mapToLong(ThuNoiTru::getAmount).sum());
                danhMucResultDTO.setUsdAmount(thuNoiTruListMatchKey.stream().allMatch(thuNoiTru -> thuNoiTru.getUsdAmount() == null) ? null : thuNoiTruListMatchKey.stream().map(ThuNoiTru::getUsdAmount).reduce(BigDecimal.ZERO, BigDecimal::add));
                danhMucResultDTO.setEurAmount(thuNoiTruListMatchKey.stream().allMatch(thuNoiTru -> thuNoiTru.getEurAmount() == null) ? null : thuNoiTruListMatchKey.stream().map(ThuNoiTru::getEurAmount).reduce(BigDecimal.ZERO, BigDecimal::add));
            }
        }

        return danhMucThuNoiTruMap.values().stream().sorted(Comparator.comparing(DanhMucThuNoiTruResultDTO::getCode)).collect(Collectors.toList());
    }

    public Map<String, DanhMucThuNoiTruResultDTO> createDanhMucThuNoiTru() {
        List<DanhMucThuNoiTru> danhMucThuNoiTruList = danhMucThuNoiTruDAO.findAll();

        Map<String, DanhMucThuNoiTruResultDTO> danhMucThuNoiTruResultDTOMap = new HashMap<>();

        for (DanhMucThuNoiTru danhMucThuNoiTru : danhMucThuNoiTruList) {
            DanhMucThuNoiTruResultDTO danhMucThuNoiTruResultDTO = DanhMucThuNoiTruResultDTO.builder()
                    .name(danhMucThuNoiTru.getName())
                    .code(danhMucThuNoiTru.getCode())
                    .build();
            danhMucThuNoiTruResultDTOMap.put(danhMucThuNoiTru.getName(), danhMucThuNoiTruResultDTO);
        }

        return danhMucThuNoiTruResultDTOMap;
    }

    public boolean checkExisting(String name, List<ThuNoiTru> thuNoiTruList) {
        return thuNoiTruList.stream().anyMatch(thuNoiTru -> thuNoiTru.getDanhMucThuNoiTru().getName().equals(name));
    }

}

