package com.decskill.test.infrastructure.out.adapter;

import com.decskill.test.infrastructure.out.repository.entity.Price;
import com.decskill.test.infrastructure.out.repository.jpa.PriceJpaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PriceRepositoryAdapterTest {

    @Mock
    private PriceJpaRepository priceJpaRepository;

    @InjectMocks
    private PriceRepositoryAdapter priceRepositoryAdapter;

    @Test
    void testFindFirstPriceBetweenDates() {
        LocalDateTime date = LocalDateTime.now();
        Long productId = 1L;
        Long brandId = 1L;
        Price expectedPrice = new Price();

        when(priceJpaRepository.findFirstPriceBetweenDates(any(LocalDateTime.class), anyLong(), anyLong()))
                .thenReturn(Optional.of(expectedPrice));

        Optional<Price> actualPrice = priceRepositoryAdapter.findFirstPriceBetweenDates(date, productId, brandId);

        assertEquals(Optional.of(expectedPrice), actualPrice);
    }
}