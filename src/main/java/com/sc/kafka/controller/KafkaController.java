package com.sc.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sc.kafka.producer.KafkaProducer;

@RestController
@RequestMapping("/api/v1")
public class KafkaController {

	@Autowired
	private KafkaProducer kafkaProducer;

	@GetMapping(value = "/producer")
	public String sendMessage(@RequestParam("message") String message) {
		kafkaProducer.sendMessageToTopic(message);
		return "Message sent Successfully to the your learning-station-topic ";
	}

}
