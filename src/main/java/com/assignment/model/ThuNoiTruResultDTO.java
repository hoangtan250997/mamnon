package com.assignment.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
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
public class ThuNoiTruResultDTO {

    private Long amount;

    private Integer year;

    private Integer month;

    private String danhMucThuNoiTruName;

    private BigDecimal usdAmount;

    private BigDecimal eurAmount;

    private String ngoaiTeAmount;
}
