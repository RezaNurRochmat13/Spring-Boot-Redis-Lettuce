package com.redis.clustered;

import com.redis.clustered.config.RedisConfig;
import com.redis.clustered.entity.cache.UserCache;
import com.redis.clustered.repo.cache.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClusteredApplication implements CommandLineRunner {
	@Autowired
	private RedisConfig redisConfig;

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(ClusteredApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		UserCache userCache = new UserCache();
		userCache.setName("Ardi");
		userCache.setAddress("Bantul");

		userRepository.save(userCache);

//		redisConfig.redisTemplate().opsForValue().set("ProgramStudent", json.toJSONString());

	}
}
