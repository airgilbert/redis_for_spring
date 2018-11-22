package com.air.redis.tools;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RedisForSpringApplication {
	public Logger log = LoggerFactory.getLogger(RedisForSpringApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RedisForSpringApplication.class, args);
	}

}
