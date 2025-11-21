package com.demo.auth.service.impl;

import com.demo.common.service.mysql.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthenticationServiceImpl {
    private final UserService userService;


}
