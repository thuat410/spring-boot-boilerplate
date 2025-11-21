package com.demo.mysql.service.impl;

import com.demo.mysql.mapper.OrderMapper;
import com.demo.mysql.repository.OrderRepository;
import com.demo.mysql.service.OrderService;
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
