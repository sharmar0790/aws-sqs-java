package com.aws.sqs.com.aws.sqs.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.stereotype.Component;

@Component
public class ConsumerListenerService {

    private static final Logger LOG = LoggerFactory.getLogger(ConsumerListenerService.class);

    private static final ObjectMapper OBJECT_MAPPER = Jackson2ObjectMapperBuilder.json().build();

    @SqsListener(value = "${destination.topic.name}",
            deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
    public void processMessage(final String message) {
        try {
            LOG.info("Received new SQS message: {}", message);

        } catch (Exception e) {
            throw new RuntimeException("Cannot process message from SQS", e);
        }
    }


}
