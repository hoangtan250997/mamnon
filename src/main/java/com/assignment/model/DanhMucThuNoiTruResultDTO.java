package com.assignment.model;

import lombok.*;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DanhMucThuNoiTruResultDTO {
    private Integer id;
    private String name;
    private Integer code;
    private Long amount;
    private BigDecimal usdAmount;
    private BigDecimal eurAmount;
}
