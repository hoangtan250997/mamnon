package com.assignment.entity.mamnon;

import java.time.LocalDateTime;

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

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="mn_holiday")
public class Holiday {
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
	 
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name="clazz_id")
	 @JsonIdentityReference(alwaysAsId = true)
	 private Clazz clazz;
	 
}
