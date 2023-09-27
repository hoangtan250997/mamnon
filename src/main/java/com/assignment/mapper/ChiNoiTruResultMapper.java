package com.assignment.mapper;

import com.assignment.entity.noitru.ChiNoiTru;
import com.assignment.model.ChiNoiTruResultDTO;
import jakarta.enterprise.context.ApplicationScoped;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;


@Mapper(componentModel = "jakarta", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ChiNoiTruResultMapper extends BaseMapper<ChiNoiTru, ChiNoiTruResultDTO> {

    @Override
//    @Mapping(target = "danhMucChiNoiTruName", source = "danhMucChiNoiTru.name")
    ChiNoiTruResultDTO toDTO(ChiNoiTru entity);
}
