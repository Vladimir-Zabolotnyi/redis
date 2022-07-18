package com.zabolotnyi.nosql.redis.jedis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;

@Configuration
public class Config {

    @Bean
    public Jedis jedis() {
        return new Jedis();
    }
}
