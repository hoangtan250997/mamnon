package com.assignment.model;

import com.assignment.entity.congdoan.CongDoanResource;
import com.assignment.entity.congdoan.CongdoanType;
import com.assignment.entity.congdoan.Region;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CongDoanTestDTO {

    private Integer id;

    private String name;
    private String address;
    private String district;
    private String city;
    private String principalName;
    private String accountantName;


}
