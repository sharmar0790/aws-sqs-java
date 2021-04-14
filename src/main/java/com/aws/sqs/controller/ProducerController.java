package com.aws.sqs.controller;

import com.aws.sqs.com.aws.sqs.service.ProducerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping
public class ProducerController {

    private static final Logger LOG = LoggerFactory.getLogger(ProducerController.class);

    @Autowired
    private ProducerService producerService;


    @GetMapping("/produceMessage/{message}")
    public void produceMessage(@PathVariable("message") String message) {
        LOG.info("Received Message {}",message);
        producerService.produce(message);
    }


}
