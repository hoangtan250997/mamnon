package com.assignment.entity.noitru;

import com.assignment.entity.congdoan.CongDoan;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "nttc_chinoitru")
public class ChiNoiTru {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Long amount;

    @NotNull
    private Integer year;

    @NotNull
    private Integer month;

    private LocalDate collectDate;

    @Size(max = 500)
    @Column(length = 500)
    private String notes;

    @ManyToOne
    @JoinColumn(name="congdoan_id")
    private CongDoan congdoan;

    @ManyToOne
    @JoinColumn(name="dmchinoitru_id")
    private DanhMucChiNoiTru danhMucChiNoiTru;

    @Column(name = "usd_amount")
    private BigDecimal usdAmount;

    @Column(name = "eur_amount")
    private BigDecimal eurAmount;

}
