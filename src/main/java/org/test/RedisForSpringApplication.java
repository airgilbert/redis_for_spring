package org.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
@ImportResource("classpath:config/dev/application-redis.xml")
public class RedisForSpringApplication {
	public Logger log = LoggerFactory.getLogger(RedisForSpringApplication.class);
	@Autowired
	public ExitCodeGenerator exitCodeGenerator;

	@Bean
	public ExitCodeGenerator exitCodeGenerator() {
		log.info("SpringBootApplication exit.................");
		return () -> 42;
	}

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(RedisForSpringApplication.class, args);
		SpringApplication.exit(context, (ExitCodeGenerator) context.getBean("exitCodeGenerator"));
	}

}
