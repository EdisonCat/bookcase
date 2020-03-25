package com.edison.bookcase.api;

import com.edison.bookcase.service.RedisSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/bookcase/redis")
public class MessageController {

    private final RedisSender sender;

    @Autowired
    public MessageController(RedisSender sender) {
        this.sender = sender;
    }

    @PostMapping(path = "message/{message}")
    public void sendMessage(@PathVariable("message") String message) {
        sender.sendDataToRedisQueue(message);
    }
}
