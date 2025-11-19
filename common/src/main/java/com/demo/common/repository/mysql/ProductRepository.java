package com.demo.common.repository.mysql;

import com.demo.common.entity.mysql.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<OrderEntity,Long> {
}
