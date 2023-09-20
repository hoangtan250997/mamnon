package com.assignment.mapper;

import com.assignment.entity.congdoan.CongDoan;
import com.assignment.model.CongDoanDTO;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "cdi", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CongDoanMapper extends BaseMapper<CongDoan, CongDoanDTO> {
}
