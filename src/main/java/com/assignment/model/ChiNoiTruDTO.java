package com.assignment.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChiNoiTruDTO {
    private Long id;

    private Long amount;

    private Integer year;

    private Integer month;

    private LocalDate collectDate;

    private String notes;


    private String congdoanId;


    private String danhMucChiNoiTruId;

    private BigDecimal usdAmount;

    private BigDecimal eurAmount;


}
