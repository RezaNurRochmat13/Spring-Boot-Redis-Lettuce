package com.redis.clustered.repo.cache;

import com.redis.clustered.entity.cache.UserCache;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserCache, Long> {
}
