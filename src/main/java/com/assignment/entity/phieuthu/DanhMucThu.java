//package com.assignment.entity.phieuthu;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.EnumType;
//import javax.persistence.Enumerated;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;
//
//
//import com.assignment.entity.congdoan.CongDoan;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.hibernate.annotations.Where;
//
//@Entity
//@Data
//@Builder(toBuilder = true)
//@NoArgsConstructor
//@AllArgsConstructor
//@Where(clause = "is_active = true")
//@Table(name="mn_danhmucthu")
//public class DanhMucThu {
//	@Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
//
//	@NotNull
//	@Size(min = 1, max = 500)
//	@Column(length = 500, nullable = false)
//	private String name;
//
//	@Builder.Default
//	private Boolean isCurrentUse = false;
//
//	@Builder.Default
//	@Column(nullable = false)
//	private Boolean isMandantory = false;
//
//	//Neu True se Tru Tien khi hoc sinh vang mat
//	@Builder.Default
//	private Boolean isAbsentCount = false;
//
//	@Builder.Default
//	@Enumerated(EnumType.STRING)
//	private CalculationType calculationType = CalculationType.MONTHLY;
//
//	private Long parentId;
//
//	@NotNull
//	@ManyToOne
//	@JoinColumn(name = "congdoan_id")
//	private CongDoan congdoan;
//
//	@ManyToOne
//	@JoinColumn(name = "code", referencedColumnName = "code")
//	private DanhMucThuMamNon dmThuMamNon;
//
//	@Column(name = "is_active", columnDefinition = "boolean default true")
//	private boolean isActive;
//}
