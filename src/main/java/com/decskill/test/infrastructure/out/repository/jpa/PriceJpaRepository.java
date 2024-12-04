package com.decskill.test.infrastructure.out.repository.jpa;

import com.decskill.test.infrastructure.out.repository.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

public interface PriceJpaRepository extends JpaRepository<Price, UUID> {

    @Query("""
                SELECT p
                FROM Price p
                WHERE :date BETWEEN p.startDate AND p.endDate
                    AND p.productId = :productId
                    AND p.brandId = :brandId
                ORDER BY p.priority DESC
                LIMIT 1
            """)
    Optional<Price> findFirstPriceBetweenDates(
            @Param("date") LocalDateTime date,
            @Param("productId") Long productId,
            @Param("brandId") Long brandId);
}
