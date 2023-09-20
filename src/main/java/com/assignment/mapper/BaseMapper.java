package com.assignment.mapper;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

/**
 * Contract for a generic mapper.
 *
 * @param <E> - Entity type parameter.
 * @param <D> - DTO type parameter.
 */
public interface BaseMapper<E, D> {

    D toDTO(E entity);

    List<D> toDTOList(List<E> entityList);
}
