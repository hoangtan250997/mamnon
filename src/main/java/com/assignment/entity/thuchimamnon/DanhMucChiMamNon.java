package com.assignment.entity.thuchimamnon;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "mntc_danhmuc_chimamnon")
public class DanhMucChiMamNon {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@Size(min = 1, max = 500)
	@Column(length = 500, nullable = false)
	private String name;
	
	@Column(unique = true, nullable=false)
	private Integer code;
	
	
}
