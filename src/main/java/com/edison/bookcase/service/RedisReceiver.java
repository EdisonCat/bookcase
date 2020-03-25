package com.edison.bookcase.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Service;


@Service
public class RedisReceiver implements MessageListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(RedisReceiver.class);

    @Override
    public void onMessage(org.springframework.data.redis.connection.Message message, byte[] pattern) {
        LOGGER.info("Received data - " + message.toString() + " from Topic - " + new String(pattern));
    }
}
