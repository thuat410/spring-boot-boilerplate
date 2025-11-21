package com.demo.mysql.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity(name = "category")
@Getter
@Setter
public class CategoryEntity extends BaseEntity {
    @Id
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    private Set<ProductEntity> products;
}
