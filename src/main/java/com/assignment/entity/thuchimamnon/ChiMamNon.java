package com.assignment.entity.thuchimamnon;

import java.time.LocalDate;
import java.time.YearMonth;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import com.assignment.entity.congdoan.CongDoan;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "mntc_chimamnon")
public class ChiMamNon {
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
	@JoinColumn(name="dmchimamnon_id")
	private DanhMucChiMamNon danhMucChiMamNon;

}
