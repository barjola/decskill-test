package com.decskill.test.infrastructure.out.repository.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "prices")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "UUID")
    private UUID id;

    private Long productId;

    private Long brandId;

    private Long priceList;

    private BigDecimal price;

    @Column(name = "curr")
    private String currency;

    private Integer priority;

    private LocalDateTime startDate;

    private LocalDateTime endDate;
}
