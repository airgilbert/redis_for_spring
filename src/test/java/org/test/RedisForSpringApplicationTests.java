package org.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.air.redis.tools.cmd.IBaseCmd;

import redis.clients.jedis.JedisPool;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisForSpringApplicationTests {
	private Logger log = LoggerFactory.getLogger(RedisForSpringApplicationTests.class);
	@Autowired
	public JedisPool jedisPool;
	@Autowired
	public IBaseCmd baseCmdImpl;

	@Test
	public void contextLoads() {
		log.info("=====================start test======================");
		System.out.println(jedisPool);
		System.out.println(baseCmdImpl);
	}

}
