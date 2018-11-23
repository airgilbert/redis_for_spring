package com.air.redis.tools.cmd.impl;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.air.redis.tools.cmd.IBaseCmd;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Component
public class BaseCmdImpl implements IBaseCmd {
	private Logger log = LoggerFactory.getLogger(BaseCmdImpl.class);
	@Autowired
	protected JedisPool jedisPool;

	@Override
	public long del(String... keys) {
		if (keys != null && keys.length > 0) {
			Jedis jedis = null;
			if (keys.length == 1) {
				return del(keys[0]);
			}
			try {
				jedis = jedisPool.getResource();
				long ok = jedis.del(keys);
				return ok;
			} catch (Exception ex) {
				log.error("BaseCmd del action is failure,The Exception :", ex);
			} finally {
				returnJedis(jedis);
			}
		}
		return 0;
	}

	/**
	 * 
	 * 删除单一的一个key元素
	 * 
	 * @see IBaseCmd#del(String...)
	 * @param key
	 * @return
	 */
	private long del(String key) {
		if (StringUtils.isNotBlank(key)) {
			Jedis jedis = null;
			try {
				jedis = jedisPool.getResource();
				long ok = jedis.del(key);
				return ok;
			} catch (Exception ex) {
				log.error("BaseCmd del action is failure,The Exception :", ex);
			} finally {
				returnJedis(jedis);
			}
		}
		return 0;
	}

	/**
	 * BaseCmdImpl中内部调用，用于jedis的关闭
	 * 
	 * @param jedis
	 */
	protected void returnJedis(Jedis jedis) {
		if (jedis != null) {
			jedis.close();
		}
	}
}
