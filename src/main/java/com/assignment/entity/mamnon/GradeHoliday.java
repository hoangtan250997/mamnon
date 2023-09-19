package com.assignment.entity.mamnon;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="mn_grade_holiday")
public class GradeHoliday {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Integer id;
	 
	 @NotNull
	 @Column(nullable = false)
	 private Integer holidayMonth;
	 
	 // store all holidays by numbers: 4,6,8,24,29 ==> will handle by code
	 @NotNull
	 @Size(min = 1, max = 200)
	 @Column(length = 200, nullable = false)
	 private String dayOffs;
	 
	 @UpdateTimestamp
	 private LocalDateTime modifiedDate;
	 
	 @ManyToOne (fetch = FetchType.LAZY)
	 @JoinColumn(name="grade_id")
	 @JsonIdentityReference(alwaysAsId = true)
	 private Grade grade;
	 
}
