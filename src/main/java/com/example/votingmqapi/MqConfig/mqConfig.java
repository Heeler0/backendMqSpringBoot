package com.example.votingmqapi.MqConfig;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class mqConfig {

    public static final String EXCHANGE_NAME = "votes";
    private static final String QUEUE_NAME = "votesQueue";

    @Bean
    public Queue createQueue() {
        //For learning purpose - durable=false,
        // in a real project you may need to set this as true.
        return new Queue(QUEUE_NAME, true);
    }
    @Bean
    public Exchange fanoutExchange() {
        // durable=true, autoDelete=false
        return new FanoutExchange(EXCHANGE_NAME, true, false);
    }
    @Bean
    public Binding queueBinding() {
        return new Binding(QUEUE_NAME, Binding.DestinationType.QUEUE, EXCHANGE_NAME, "", null);
    }
}
