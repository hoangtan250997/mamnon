package com.assignment.mapper;

import com.assignment.entity.noitru.ChiNoiTru;
import com.assignment.model.ChiNoiTruDTO;
import jakarta.enterprise.context.ApplicationScoped;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;


@Mapper(componentModel = "jakarta")
public interface ChiNoiTruMapper extends BaseMapper<ChiNoiTru, ChiNoiTruDTO> {

    @Override
    @Mapping(target = "danhMucChiNoiTruId", source = "danhMucChiNoiTru.id")
    ChiNoiTruDTO toDTO(ChiNoiTru entity);
}
