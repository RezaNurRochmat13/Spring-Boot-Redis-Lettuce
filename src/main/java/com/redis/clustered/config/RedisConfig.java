package com.redis.clustered.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableConfigurationProperties(RedisProperties.class)
public class RedisConfig {
    @Value("${spring.redis.nodes[0]}")
    private String redisFirstNodes;

    @Value("${spring.redis.nodes[1]}")
    private String redisTwoNodes;

    @Value("${spring.redis.nodes[2]}")
    private String redisThreeNodes;

    @Value("${spring.redis.host")
    private String redisHost;

    @Bean
    public JedisConnectionFactory redisConnectionFactory() {
        List<String> clusterNodes = new ArrayList<>();
        clusterNodes.add(redisFirstNodes);
        clusterNodes.add(redisTwoNodes);
        clusterNodes.add(redisThreeNodes);

        return new JedisConnectionFactory(new RedisClusterConfiguration(clusterNodes));
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        final RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();

        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        redisTemplate.setConnectionFactory(redisConnectionFactory());

        return redisTemplate;
    }
}

