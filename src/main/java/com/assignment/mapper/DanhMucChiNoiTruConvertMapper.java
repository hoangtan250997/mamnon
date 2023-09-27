package com.assignment.mapper;

import com.assignment.entity.noitru.DanhMucChiNoiTru;
import com.assignment.model.DanhMucChiNoiTruResultDTO;
import jakarta.enterprise.context.ApplicationScoped;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "jakarta", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface DanhMucChiNoiTruConvertMapper extends BaseMapper<DanhMucChiNoiTru, DanhMucChiNoiTruResultDTO> {
}
