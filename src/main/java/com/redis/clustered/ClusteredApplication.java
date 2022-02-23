package com.redis.clustered;

import com.redis.clustered.config.RedisConfig;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class ClusteredApplication implements CommandLineRunner {
	@Autowired
	private RedisConfig redisConfig;

	public static void main(String[] args) {
		SpringApplication.run(ClusteredApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		JSONObject json = new JSONObject();
		json.put("name", "Ardi");
		json.put("age", 23);

		redisConfig.redisTemplate().opsForValue().set("ProgramStudent", json.toJSONString());

	}
}
