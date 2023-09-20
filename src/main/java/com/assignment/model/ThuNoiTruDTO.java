package com.assignment.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ThuNoiTruDTO {
    private Long id;

    private Long amount;

    private Integer year;

    private Integer month;

    private LocalDate collectDate;

    private String notes;

    private String congdoanId;

    private String danhMucThuNoiTruId;

    private BigDecimal usdAmount;

    private BigDecimal eurAmount;

    private String ngoaiTeAmount;
}
