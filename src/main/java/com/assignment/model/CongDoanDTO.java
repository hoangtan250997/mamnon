package com.assignment.model;

import com.assignment.entity.congdoan.CongDoanResource;
import com.assignment.entity.congdoan.CongdoanType;
import com.assignment.entity.congdoan.Region;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
@RegisterForReflection(targets = {CongDoanDTO.class})
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

    private boolean abroad;

    private Region region;

    private CongdoanType type;
}
