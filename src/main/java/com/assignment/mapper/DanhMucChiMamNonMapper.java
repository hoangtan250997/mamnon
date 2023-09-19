package com.assignment.mapper;

import com.assignment.entity.thuchimamnon.DanhMucChiMamNon;
import com.assignment.model.DanhMucChiMamNonDTO;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "cdi", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface DanhMucChiMamNonMapper extends BaseMapper<DanhMucChiMamNon, DanhMucChiMamNonDTO> {
}
