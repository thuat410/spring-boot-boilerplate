package com.demo.mysql.id;

import com.demo.mysql.properties.SnowflakeProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
@EnableConfigurationProperties(SnowflakeProperties.class)
public class IdConfig {
    private final SnowflakeProperties properties;

    @Bean
    public FastSnowflake snowflake() {
        return new FastSnowflake(properties.workerId(), properties.dataCenterId());
    }
}
