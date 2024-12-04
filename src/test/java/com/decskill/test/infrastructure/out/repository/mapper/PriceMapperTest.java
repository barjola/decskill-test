package com.decskill.test.infrastructure.out.repository.mapper;

import com.decskill.test.utils.MockUtils;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PriceMapperTest {

    private final PriceMapper mapper = Mappers.getMapper(PriceMapper.class);

    @Test
    void toDto() {
        var price = MockUtils.aPrice();

        var result = mapper.toDto(price);

        assertNotNull(result);
        assertEquals(price.getProductId(), result.productId());
        assertEquals(price.getBrandId(), result.brandId());
        assertEquals(price.getPriceList(), result.priceList());
        assertEquals(price.getStartDate(), result.startDate());
        assertEquals(price.getEndDate(), result.endDate());
        assertEquals(price.getPrice(), result.price());
        assertEquals(price.getCurrency(), result.currency());

    }
}