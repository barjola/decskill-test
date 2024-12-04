package com.decskill.test.application.usecases;

import com.decskill.test.domain.exception.PriceNotFoundException;
import com.decskill.test.domain.model.PriceModel;
import com.decskill.test.infrastructure.out.repository.jpa.PriceJpaRepository;
import com.decskill.test.infrastructure.out.repository.mapper.PriceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PriceUseCase {

    private final PriceJpaRepository priceJpaRepository;
    private final PriceMapper priceMapper;

    public PriceModel queryPrice(LocalDateTime date, Long productId, Long brandId) {
        return priceJpaRepository.findFirstPriceBetweenDates(date, productId, brandId)
                .map(priceMapper::toDto)
                .orElseThrow(() -> new PriceNotFoundException(date, productId, brandId));
    }

}
