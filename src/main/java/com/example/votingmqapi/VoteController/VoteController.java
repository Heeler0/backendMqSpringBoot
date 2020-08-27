package com.example.votingmqapi.VoteController;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class VoteController {

    private final AmqpTemplate amqpTemplate;

    @Autowired
    public VoteController(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    @RequestMapping(value = "/vote", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String process(@RequestBody Map<String, String> animalType) {
        try {
            amqpTemplate.convertAndSend("votes", "", animalType.get("animal"));

        } catch (Exception e) {
            return "Could not place the vote";
        }
        return "Success";
    }
}
