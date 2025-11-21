package com.demo.mysql.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "snowflake")
public record SnowflakeProperties(long workerId, long dataCenterId) {
}
