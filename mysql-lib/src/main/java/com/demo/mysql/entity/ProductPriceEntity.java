package com.demo.mysql.entity;

import com.demo.mysql.enums.CurrencyEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity(name = "product_price")
@Getter
@Setter
public class ProductPriceEntity {
    @Id
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private ProductEntity product;

    @Column(nullable = false, length = 3)
    @Enumerated(EnumType.STRING)
    private CurrencyEnum currency;

    @Column(nullable = false)
    private BigDecimal amount;
}
