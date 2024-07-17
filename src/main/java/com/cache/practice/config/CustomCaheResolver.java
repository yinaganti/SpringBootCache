package com.cache.practice.config;

import java.util.Collection;
import java.util.Collections;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.interceptor.CacheOperationInvocationContext;
import org.springframework.cache.interceptor.CacheResolver;
import org.springframework.stereotype.Component;

@Component
public class CustomCaheResolver implements CacheResolver{

	private final CacheManager cacheManager;
	
	public CustomCaheResolver(CacheManager cacheManager) {
		this.cacheManager = cacheManager;
	}
	
	@Override
	public Collection<? extends Cache> resolveCaches(CacheOperationInvocationContext<?> context) {
		String cacheName = determineCacheName(context);
		Cache cache = cacheManager.getCache(cacheName);
        return Collections.singletonList(cache);
	}

	private String determineCacheName(CacheOperationInvocationContext<?> context) {
		Object[] args = context.getArgs();
		return args[0].toString();
	}

}
