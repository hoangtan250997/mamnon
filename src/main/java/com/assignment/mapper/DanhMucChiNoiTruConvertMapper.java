package com.assignment.mapper;

import com.assignment.entity.noitru.DanhMucChiNoiTru;
import com.assignment.model.DanhMucChiNoiTruResultDTO;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "cdi", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface DanhMucChiNoiTruConvertMapper extends BaseMapper<DanhMucChiNoiTru, DanhMucChiNoiTruResultDTO> {
}
