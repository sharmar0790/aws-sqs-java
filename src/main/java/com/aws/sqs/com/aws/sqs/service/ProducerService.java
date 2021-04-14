package com.aws.sqs.com.aws.sqs.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {
    private static final Logger LOG = LoggerFactory.getLogger(ProducerService.class);

    @Value("${destination.topic.name}")
    private String destinationQueueName;

    @Autowired
    private MessageSenderService senderService;

    public void produce(final String message) {
        senderService.send(message, null, destinationQueueName);
    }
}
