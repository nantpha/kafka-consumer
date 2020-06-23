package com.example.kafkaproducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("kafka")
public class KafkaController {
	
	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;
	
	private static final String TOPIC="SPRINT";
	
	@GetMapping("name/{value}")
	public String getKafka(@PathVariable("value") String value)
	{
		System.out.println("hello@@@@@@@@@@@@@@@@@@@@@"+value);
		kafkaTemplate.send(TOPIC,value);
		return "Success";
	}
	
	
	

}
