package com.edison.bookcase.dao;

import com.edison.bookcase.service.RedisReceiver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.GenericToStringSerializer;

import java.util.UUID;
import java.util.concurrent.Executors;

@Configuration
public class RedisMessageConfig {

    @Bean(name = "RedisMessageConnector")
    public JedisConnectionFactory connectionFactory() {
        return new JedisConnectionFactory();
    }

    @Bean(name = "RedisMessageTemplate")
    public RedisTemplate<String, String> redisTemplate() {
        RedisTemplate<String, String> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory());
        template.setValueSerializer(new GenericToStringSerializer<>(String.class));
        return template;
    }

    @Bean
    ChannelTopic topic() {
        return new ChannelTopic(UUID.randomUUID().toString());
    }

    @Bean
    RedisMessageListenerContainer redisContainer() {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory());
        container.addMessageListener(new MessageListenerAdapter(new RedisReceiver()), topic());
        container.setTaskExecutor(Executors.newFixedThreadPool(4));
        return container;
    }
}
