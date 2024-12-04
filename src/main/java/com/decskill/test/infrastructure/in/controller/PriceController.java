package com.decskill.test.infrastructure.in.controller;

import com.decskill.test.application.usecases.PriceUseCase;
import com.decskill.test.domain.model.PriceModel;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/price")
public class PriceController {

    private final PriceUseCase priceUseCase;

    @GetMapping
    @Operation(description = "Get price for a product and brand at a date", tags = "price")
    public PriceModel queryPrice(
            @RequestParam("date") @Parameter(example = "2020-06-14T10:00:00.000+01:00") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date,
            @RequestParam("productId") @Parameter(example = "35455") Long productId,
            @RequestParam("brandId") @Parameter(example = "1") Long brandId) {
        return priceUseCase.queryPrice(date, productId, brandId);
    }
}
