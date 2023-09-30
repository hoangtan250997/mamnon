package com.assignment.entity.thuchimamnon;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "mntc_danhmuc_chimamnon")
@RegisterForReflection
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
