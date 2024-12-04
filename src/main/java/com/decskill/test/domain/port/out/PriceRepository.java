package com.decskill.test.domain.port.out;

import com.decskill.test.infrastructure.out.repository.entity.Price;

import java.time.LocalDateTime;
import java.util.Optional;

public interface PriceRepository {

    Optional<Price> findFirstPriceBetweenDates(
            LocalDateTime date,
            Long productId,
            Long brandId);
}
