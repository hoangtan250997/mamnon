package com.assignment.mapper;

import com.assignment.entity.noitru.ThuNoiTru;
import com.assignment.model.ThuNoiTruDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;


@Mapper(componentModel = "cdi", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ThuNoiTruMapper extends BaseMapper<ThuNoiTru, ThuNoiTruDTO> {

    @Override
    @Mapping(target = "congdoanId", source = "congdoan.id")
    @Mapping(target = "danhMucThuNoiTruId", source = "danhMucThuNoiTru.id")
    ThuNoiTruDTO toDTO(ThuNoiTru entity);
}
