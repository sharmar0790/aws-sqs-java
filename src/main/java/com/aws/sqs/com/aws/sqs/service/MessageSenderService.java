package com.aws.sqs.com.aws.sqs.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class MessageSenderService {
    private static final Logger LOG = LoggerFactory.getLogger(MessageSenderService.class);

    @Autowired
    private QueueMessagingTemplate queueMessagingTemplate;

    public <T> void send(final T message, final Map<String, Object> headers, final String topicName) {
        try {
            if (message == null) {
                LOG.warn("SQS Producer cant produce 'null' value");
                return;
            }

            LOG.info(" Messgae {} ", message);
            LOG.info(" Queue name {} ", topicName);
            queueMessagingTemplate.convertAndSend(topicName, message, headers);
        } catch (Exception e) {
            LOG.error("Error caught while sending messge to AMZ SQS {0}", e);
        }
    }

}
