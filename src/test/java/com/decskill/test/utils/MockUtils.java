package com.decskill.test.utils;

import com.decskill.test.domain.model.PriceModel;
import com.decskill.test.infrastructure.out.repository.entity.Price;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class MockUtils {

    public static Price aPrice() {
        return new Price(
                UUID.randomUUID(),
                11L,
                22L,
                33L,
                new BigDecimal("44.0"),
                "EUR",
                1,
                LocalDateTime.now(),
                LocalDateTime.now().plusDays(1));
    }

    public static PriceModel aPriceModel() {
        return new PriceModel(
                11L,
                22L,
                33L,
                LocalDateTime.now(),
                LocalDateTime.now().plusDays(1),
                new BigDecimal("44.0"),
                "EUR"
        );
    }
}
