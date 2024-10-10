package com.dboaz.infra.dev.redis;


import com.dboaz.ms_auth.core.mappers.AccountMapper;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;

@Configuration
@Profile({"dev", "test", "global_ms"})
public class RedisConfig {

    @Bean
    public RedisTemplate<String, AccountMapper> redisTemplate(RedisConnectionFactory factory) {

        RedisTemplate<String, AccountMapper> template = new RedisTemplate<>();
        template.setConnectionFactory(factory);

        // Configurar a serialização
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.activateDefaultTyping(
            LaissezFaireSubTypeValidator.instance, 
            ObjectMapper.DefaultTyping.NON_FINAL, 
            JsonTypeInfo.As.PROPERTY
        );

        Jackson2JsonRedisSerializer<AccountMapper> serializer = new Jackson2JsonRedisSerializer<>(objectMapper, AccountMapper.class);

        // Definir os serializers de chave e valor
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(serializer);
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(serializer);

        template.afterPropertiesSet();

        return template;
    }
}
