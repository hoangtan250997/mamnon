package com.assignment.mapper;

import com.assignment.entity.congdoan.CongDoan;
import com.assignment.model.CongDoanDTO;
import com.assignment.model.CongDoanTestDTO;
import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.ApplicationScoped;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "jakarta", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
@RegisterForReflection
public interface CongDoanMapper extends BaseMapper<CongDoan, CongDoanTestDTO> {
}
