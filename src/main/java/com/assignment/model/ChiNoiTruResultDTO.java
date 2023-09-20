package com.assignment.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChiNoiTruResultDTO {
    private String danhMucChiNoiTruName;
    private Long amount;
    private Integer month;
    private Integer year;
    private BigDecimal usdAmount;
    private BigDecimal eurAmount;


}