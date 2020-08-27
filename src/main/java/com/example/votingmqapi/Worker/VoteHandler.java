package com.example.votingmqapi.Worker;


import com.example.votingmqapi.Database.Votes;
import com.example.votingmqapi.Database.VotesRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoteHandler {

    @Autowired
    VotesRepository votesRepository;


    @RabbitListener(queues = "votesQueue")
    public void receiveMessage(String message) {
        Votes vote = new Votes(message);
        votesRepository.save(vote);
    }

}
