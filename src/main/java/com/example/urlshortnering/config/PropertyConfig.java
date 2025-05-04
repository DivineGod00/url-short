package com.example.urlshortnering.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({
	@PropertySource(value = "classpath:application.properties"),
	@PropertySource(value = "classpath:postgreSqlConfig.properties"),
	@PropertySource(value = "classpath:MongoDbConfig.properties"),
	@PropertySource(value = "classpath:RedisConfig.properties")
})
public class PropertyConfig {

}
