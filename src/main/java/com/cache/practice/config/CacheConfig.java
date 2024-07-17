package com.cache.practice.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class CacheConfig {
	
	/*
	 * by default it will use so, cache will clear when application restart
	 * 
	 * We need to use RedisCacheManager, Hazelcast, etc...
	 */
	
	@Bean
	CacheManager cacheManager() {
		return new ConcurrentMapCacheManager();
	}

}
