package com.demo.mysql.id;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class Id {
    private static FastSnowflake generator;
    private final FastSnowflake injectedGenerator;

    private Id(FastSnowflake injectedGenerator) {
        this.injectedGenerator = injectedGenerator;
    }

    @PostConstruct
    private void init() {
        Id.generator = injectedGenerator;
    }

    public static long next() {
        if (generator == null) throw new IllegalStateException("Id generator not initialized");
        return generator.nextId();
    }
}
