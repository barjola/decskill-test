package com.decskill.test.domain.model;


import java.math.BigDecimal;
import java.time.LocalDateTime;


public record PriceModel(Long productId,
                         Long brandId,
                         Long priceList,
                         LocalDateTime startDate,
                         LocalDateTime endDate,
                         BigDecimal price,
                         String currency) {
}
