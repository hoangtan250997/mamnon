package com.assignment.entity.mamnon;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
