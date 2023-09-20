package com.assignment.mapper;

import com.assignment.entity.noitru.ChiNoiTru;
import com.assignment.model.ChiNoiTruDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;


@Mapper(componentModel = "cdi", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ChiNoiTruMapper extends BaseMapper<ChiNoiTru, ChiNoiTruDTO> {

    @Override
    @Mapping(target = "congdoanId", source = "congdoan.id")
    @Mapping(target = "danhMucChiNoiTruId", source = "danhMucChiNoiTru.id")
    ChiNoiTruDTO toDTO(ChiNoiTru entity);
}
