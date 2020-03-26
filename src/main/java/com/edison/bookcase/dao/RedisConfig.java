package com.edison.bookcase.dao;

import com.edison.bookcase.model.Book;
import com.edison.bookcase.service.RedisConfigSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;


@Configuration
public class RedisConfig {

    @Autowired
    private RedisConfigSerializer redisSerializer;

    @Bean(name = "RedisCachingConnector")
    @Primary
    public JedisConnectionFactory jedisConnectionFactory() {
        //        jedisConnectionFactory.setUsePool(true);
//        jedisConnectionFactory.setHostName("localhost");
//        jedisConnectionFactory.setPort(6379);
        return new JedisConnectionFactory();
    }

    @Bean(name = "RedisCachingTemplate")
    public RedisTemplate<String, Book> redisTemplate() {
        RedisTemplate<String, Book> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory());
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(redisSerializer);
        return template;
    }

    @Bean
    public RedisCacheManager redisCacheManager() {
        RedisCacheManager manager = RedisCacheManager.create(jedisConnectionFactory());
        manager.setTransactionAware(true);
        return manager;
    }

}
