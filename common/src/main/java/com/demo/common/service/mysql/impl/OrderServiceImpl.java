package com.demo.common.service.mysql.impl;

import com.demo.common.mapper.OrderMapper;
import com.demo.common.repository.mysql.OrderRepository;
import com.demo.common.service.mysql.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {
    private final OrderRepository repository;
    private final OrderMapper mapper;
}
