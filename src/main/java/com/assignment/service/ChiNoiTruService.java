package com.assignment.service;


import com.assignment.dao.ChiNoiTruDAO;
import com.assignment.dao.DanhMucChiNoiTruDAO;
import com.assignment.entity.noitru.ChiNoiTru;
import com.assignment.entity.noitru.DanhMucChiNoiTru;
import com.assignment.model.DanhMucChiNoiTruResultDTO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@ApplicationScoped
public class ChiNoiTruService {

    @Inject
    ChiNoiTruDAO chiNoiTruDAO;

    @Inject
    DanhMucChiNoiTruDAO danhMucChiNoiTruDAO;


    public List<ChiNoiTru> findAll() {
        return chiNoiTruDAO.findAll();

    }


    public List<DanhMucChiNoiTruResultDTO> findByCongdoanAndMonth(int condoanId, int month, int year) {

        List<ChiNoiTru> chiNoiTruList = chiNoiTruDAO.findByMonth(month, year)
                .stream()
                .filter(chiNoiTru -> chiNoiTru.getCongdoan().getId() == condoanId)
                .collect(Collectors.toList());

        Map<String, DanhMucChiNoiTruResultDTO> danhMucChiNoiTruMap = createDanhMucChiNoiTru();

        for (ChiNoiTru chiNoiTru : chiNoiTruList) {
            String key = chiNoiTru.getDanhMucChiNoiTru().getName();
            danhMucChiNoiTruMap.get(key).setAmount(chiNoiTru.getAmount());
            danhMucChiNoiTruMap.get(key).setUsdAmount(chiNoiTru.getUsdAmount());
            danhMucChiNoiTruMap.get(key).setEurAmount(chiNoiTru.getEurAmount());
        }

        return danhMucChiNoiTruMap.values().stream().sorted(Comparator.comparing(DanhMucChiNoiTruResultDTO::getCode)).collect(Collectors.toList());

    }

    public List<DanhMucChiNoiTruResultDTO> findByMonthForAllCongDoan(int month, int year) {
        List<ChiNoiTru> chiNoiTruList = chiNoiTruDAO.findByMonth(month, year)
                .stream()
                .collect(Collectors.toList());
        Map<String, DanhMucChiNoiTruResultDTO> danhMucChiNoiTruMap = createDanhMucChiNoiTru();

        for (Map.Entry<String, DanhMucChiNoiTruResultDTO> danhMucChiNoiTru : danhMucChiNoiTruMap.entrySet()) {
            String key = danhMucChiNoiTru.getKey();
            if (checkExisting(key, chiNoiTruList)) {
                DanhMucChiNoiTruResultDTO danhMucResultDTO = danhMucChiNoiTru.getValue();

                List<ChiNoiTru> chiNoiTruListMatchKey = chiNoiTruList.stream()
                        .filter(chiNoiTru -> chiNoiTru.getDanhMucChiNoiTru().getName().equals(key)).collect(Collectors.toList());

                danhMucResultDTO.setAmount(chiNoiTruListMatchKey.stream().mapToLong(ChiNoiTru::getAmount).sum());
                danhMucResultDTO.setUsdAmount(chiNoiTruListMatchKey.stream().map(ChiNoiTru::getUsdAmount).reduce(BigDecimal.ZERO, BigDecimal::add));
                danhMucResultDTO.setEurAmount(chiNoiTruListMatchKey.stream().map(ChiNoiTru::getEurAmount).reduce(BigDecimal.ZERO, BigDecimal::add));
            }
        }


        return danhMucChiNoiTruMap.values().stream().sorted(Comparator.comparing(DanhMucChiNoiTruResultDTO::getCode)).collect(Collectors.toList());
    }

    public Map<String, DanhMucChiNoiTruResultDTO> createDanhMucChiNoiTru() {
        List<DanhMucChiNoiTru> danhMucChiNoiTruList = danhMucChiNoiTruDAO.findAll();

        Map<String, DanhMucChiNoiTruResultDTO> danhMucChiNoiTruResultDTOMap = new HashMap<>();

        for (DanhMucChiNoiTru danhMucChiNoiTru : danhMucChiNoiTruList) {
            DanhMucChiNoiTruResultDTO danhMucChiNoiTruResultDTO = DanhMucChiNoiTruResultDTO.builder()
                    .name(danhMucChiNoiTru.getName())
                    .code(danhMucChiNoiTru.getCode())
                    .build();
            danhMucChiNoiTruResultDTOMap.put(danhMucChiNoiTru.getName(), danhMucChiNoiTruResultDTO);
        }

        return danhMucChiNoiTruResultDTOMap;
    }

    public boolean checkExisting(String name, List<ChiNoiTru> chiNoiTruList) {
        return chiNoiTruList.stream().anyMatch(chiNoiTru -> chiNoiTru.getDanhMucChiNoiTru().getName().equals(name));
    }

}

