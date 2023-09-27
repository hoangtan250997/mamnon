package com.assignment.entity.phieuthu;

import com.assignment.entity.mamnon.Grade;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name="mn_duthu")
public class DuThu {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Integer amount;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "danhmucthu_id")
	private DanhMucThu danhMucThu;

	@Column(nullable = false)
	@Default
	private Boolean isMandantory = false;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "grade_id")
	private Grade grade;

	@UpdateTimestamp
	private LocalDate modifiedDate;
}
