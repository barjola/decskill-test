package com.decskill.test.infrastructure.out.repository.mapper;

import com.decskill.test.domain.model.PriceModel;
import com.decskill.test.infrastructure.out.repository.entity.Price;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PriceMapper {

    PriceModel toDto(Price entity);
}