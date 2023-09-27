package com.assignment.entity.congdoan;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"id"})
public class CongDoanResource {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(unique = true, nullable=false)
	private String name;
	
	@Enumerated(EnumType.STRING)
	private ResourceType type;
	
	private String manager;
	
	@ManyToOne
	@JoinColumn(name="congdoan_id")
	@JsonBackReference
	private CongDoan congdoan;
	
}
