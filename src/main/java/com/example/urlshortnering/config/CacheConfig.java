package com.example.urlshortnering.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class CacheConfig {

//	@Bean
//	public CacheManager redisCacheManager(RedisConnectionFactory redisConnectionFactory) {
//	    
//		RedisCacheConfiguration defaultConfig = RedisCacheConfiguration.defaultCacheConfig()
//	            .entryTtl(Duration.ofMinutes(10));
//
//	    Map<String, RedisCacheConfiguration> cacheConfigs = new HashMap<>();
//	    cacheConfigs.put("url-shortner", RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofMinutes(5)));
//	    
//	    
//	    System.out.println("Cache :::--> "+cacheConfigs);
//	    System.out.println("defaultConfig :::--> "+defaultConfig);
//	    
//	    return RedisCacheManager.builder(redisConnectionFactory)
//	            .cacheDefaults(defaultConfig)
//	            .withInitialCacheConfigurations(cacheConfigs)
//	            .build();
//	}
}
