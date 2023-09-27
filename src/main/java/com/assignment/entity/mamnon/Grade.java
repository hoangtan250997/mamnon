package com.assignment.entity.mamnon;

import com.assignment.entity.congdoan.CongDoan;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="mn_grade")
@Builder
public class Grade {
	private static final String QUALIFIER ="com.assignment.entity.mamnon.Grade.";

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Integer id;
	 
	 @NotNull
	 @Size(min = 1, max = 300)
	 @Column(length = 300, nullable = false)
	 private String name;
	 
	 @NotNull
	 @Size(min = 1, max = 100)
	 @Column(length = 100, nullable = false)
	 private String academicYear;
	 
	 @ManyToOne
	 @JoinColumn(name="congdoan_id")
	 private CongDoan congdoan;
	
}
