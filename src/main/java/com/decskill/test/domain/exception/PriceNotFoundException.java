package com.decskill.test.domain.exception;

import java.time.LocalDateTime;

public class PriceNotFoundException extends RuntimeException {

    public PriceNotFoundException(LocalDateTime date, Long productId, Long brandId) {
        super("Price not found for date: " + date + " productId: " + productId + " brandId: " + brandId);
    }
}
