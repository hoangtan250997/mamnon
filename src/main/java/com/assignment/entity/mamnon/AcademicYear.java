package com.assignment.entity.mamnon;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Data
@Table(name="mn_academicyear")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AcademicYear {
	@Id
	private String name;

	private Integer usdExchangeRate;

	private Integer congDoanStartMonth;

	private Integer congDoanNumOfMonth;
}
