package com.assignment.model;

import com.assignment.entity.congdoan.CongDoanResource;
import com.assignment.entity.congdoan.CongdoanType;
import com.assignment.entity.congdoan.Region;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CongDoanDTO {

    private Integer id;

    private String name;
    private String address;
    private String district;
    private String city;
    private String principalName;
    private String accountantName;

    private String congDoanName;

    private String paymentDueDate;

    private String paymentSentDate;

	private LocalDateTime createdDate;

	private LocalDateTime updatedDate;


	private List<CongDoanResource> congdoanResources;

    @Column(name = "is_abroad", columnDefinition = "boolean default false")
    private boolean abroad;

    @Column
    @Enumerated(EnumType.STRING)
    private Region region;

    @Column
    @Enumerated(EnumType.STRING)
    private CongdoanType type;
}
