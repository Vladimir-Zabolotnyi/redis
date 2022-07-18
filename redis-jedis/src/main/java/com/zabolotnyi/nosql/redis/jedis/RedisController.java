package com.zabolotnyi.nosql.redis.jedis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import static org.springframework.http.HttpStatus.OK;

@Slf4j
@RestController
public class RedisController {
    @Autowired
    Jedis jedis;

    @ResponseStatus(OK)
    @GetMapping("api/value")
    public String getValue(@RequestParam(name = "key") String key) {
        String value = jedis.get(key);
        log.info("Key:" + key + " Value:" + value);
        return value;
    }

    @ResponseStatus(OK)
    @PostMapping("api/map")
    public String postKeyValue(@RequestBody KeyValueDTO dto) {
        String key = dto.key();
        String value = dto.value();
        jedis.set(key, value);
        log.info("Key:" + key + " Value:" + value);
        return "Done";
    }
}
