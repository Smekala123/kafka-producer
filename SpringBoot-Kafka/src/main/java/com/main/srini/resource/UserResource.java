package com.main.srini.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class UserResource {
	private static final String  TOPIC="kafka_example";  
	@Autowired
	KafkaTemplate<String,String> kafkaTemplate;
	
	@GetMapping("publish/{message}")
	public String post(@PathVariable("message") final String message) {
		kafkaTemplate.send(TOPIC , message);
		return "Published Successfully";
	}

}
