package com.example.votingmqapi.Worker;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class VoteHandler {



    @RabbitListener(queues = "votesQueue")
    public void receiveMessage(String message) {
        System.out.println("Received Message:" + message);
        System.out.println();
    }

}
