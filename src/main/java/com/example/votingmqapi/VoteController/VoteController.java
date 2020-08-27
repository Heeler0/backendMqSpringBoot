package com.example.votingmqapi.VoteController;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VoteController {

    private final AmqpTemplate amqpTemplate;

    @Autowired
    public VoteController(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    @GetMapping("/sendMessage")
    public String sendMessage() {
        amqpTemplate.convertAndSend("votes", "", "");
        return "Message Sent";
    }
}
