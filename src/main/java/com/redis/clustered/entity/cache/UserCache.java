package com.redis.clustered.entity.cache;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

@RedisHash(value = "UserCache", timeToLive = 1209600000L)
@Getter
@Setter
public class UserCache implements Serializable {
    @Id
    private Long id;

    @TimeToLive(unit = TimeUnit.DAYS)
    private final Integer expiration = 7;

    private String name;

    private String address;
}
